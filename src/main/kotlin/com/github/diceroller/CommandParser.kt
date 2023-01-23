package com.github.diceroller

import com.github.diceroller.handler.Command
import com.github.diceroller.handler.Update
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.MessageEntity
import com.github.kotlintelegrambot.entities.Update as TelegramUpdate

class CommandParser(botName: String) {

    private val pureCommands: Map<String, Command> = mapOf<String, Command>()
        // Regular commands
        .plus(Command.values().associateBy { cmd -> cmd.text })
        // Inline commands
        .plus(Command.diceRolls().associateBy { cmd -> "${cmd.text}@$botName" })

    fun parse(update: TelegramUpdate): Update? {
        val message: Message = update.message ?: return null

        val chatId = ChatId.fromId(message.chat.id)
        if (message.dice != null) {
            return Update(chatId, dice = message.dice?.value)
        }

        val text = message.text ?: ""
        if (pureCommands.contains(text)) {
            return Update(chatId, command = pureCommands[text])
        }

        val entities = update.message?.entities ?: emptyList()
        val mentions = entities.filter { it.type == MessageEntity.Type.MENTION }
            .map { text.substring(it.offset, it.length) }

        val commands = entities.filter { it.type == MessageEntity.Type.BOT_COMMAND }
            .map { text.substring(it.offset, it.length) }

        val command = pureCommands[text.substringBefore(' ')]

        return Update(chatId, command, text, mentions, commands)
    }
}