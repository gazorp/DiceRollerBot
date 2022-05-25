package com.github.diceroller.handler

import com.github.diceroller.equivocals.EquivocalsCardRepository
import com.github.diceroller.equivocals.TaskType
import com.github.kotlintelegrambot.dispatcher.handlers.HandleMessage
import com.github.kotlintelegrambot.entities.ChatAction
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.extensions.filters.Filter

class EquivocalsMessageHandler(val cards: EquivocalsCardRepository) : MessageHandler() {

    override fun filter(): Filter = object : Filter {
        override fun Message.predicate(): Boolean = dice != null
    }

    override fun handleMessage(): HandleMessage = {
        val chatId = ChatId.fromId(message.chat.id)
        bot.sendChatAction(chatId, ChatAction.TYPING)

        val diceValue = update.message!!.dice!!.value
        val cardType = TaskType.values().firstOrNull { it.dice == diceValue }
        val card = if (cardType != null) cards.getRandom(cardType) else null

        Thread.sleep(4000)

        if (card != null) {
            val msg = "Экивоки!\n" +
                "Тема: ${card.theme.title()}\n" +
                "${card.type.emoji()}: ${card.description}\n\n" + card.task
            bot.sendMessage(chatId, msg)
        } else {
            bot.sendMessage(chatId, "Карточки для \"$diceValue\" закончились")
        }

        update.consume()
    }
}