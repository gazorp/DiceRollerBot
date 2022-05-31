package com.github.diceroller.handler

import com.github.diceroller.equivocals.EquivocalsCardRepository
import com.github.diceroller.equivocals.TaskType
import com.github.kotlintelegrambot.dispatcher.handlers.HandleMessage
import com.github.kotlintelegrambot.entities.ChatAction
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.extensions.filters.Filter

class EquivocalsMessageHandler(val cards: EquivocalsCardRepository) : MessageHandler() {

    override fun filter(): Filter = object : Filter {
        override fun Message.predicate(): Boolean = dice != null || text == COMMAND
    }

    override fun handleMessage(): HandleMessage = {
        val chatId = ChatId.fromId(message.chat.id)
        bot.sendChatAction(chatId, ChatAction.TYPING)

        val cardType = if (update.message?.dice != null) {
            val diceValue = update.message?.dice?.value
            Thread.sleep(4000)
            TaskType.values().firstOrNull { it.dice == diceValue }
        } else {
            TaskType.values().random()
        }

        val card = if (cardType != null) cards.getRandom(cardType) else null

        if (card != null) {
            val msg = "Экивоки\\!\n" +
                "Тема\\: ${card.theme.title()}\n" +
                "${card.type.emoji()}: ${card.description}\n\n" + card.task
            bot.sendMessage(chatId, msg, ParseMode.MARKDOWN_V2)
        } else {
            bot.sendMessage(chatId, "Карточки для \"${cardType?.dice}\" закончились")
        }

        update.consume()
    }

    companion object {
        private const val COMMAND = "/equivocals"
    }
}