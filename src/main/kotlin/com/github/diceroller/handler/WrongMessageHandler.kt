package com.github.diceroller.handler

import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.MessageEntity.Type.BOT_COMMAND
import com.github.kotlintelegrambot.entities.MessageEntity.Type.MENTION

class WrongMessageHandler(private val botName: String) : Handler {

    override fun handle(dispatcher: Dispatcher) = dispatcher.message {
        val entities = update.message?.entities ?: emptyList()
        val text = update.message?.text ?: ""

        if (entities.any { it.type == MENTION } && text.startsWith("@$botName")) {
            bot.sendSticker(ChatId.fromId(update.message?.chat?.id!!), funnyStickers.random(), replyMarkup = null)
            update.consume()
        }

        if (entities.any { it.type == BOT_COMMAND } && text.contains("@$botName")) {
            bot.sendSticker(ChatId.fromId(update.message?.chat?.id!!), funnyStickers.random(), replyMarkup = null)
            update.consume()
        }
    }

    companion object {
        private val funnyStickers = listOf(
            "CAACAgIAAxkBAAIBUWBuL0qk_bujKwJSei1qlMjQmx79AAI5AAMphsY9_bg97wvV_TseBA", // Lapenko sto
            "CAACAgIAAxkBAAIBUGBuLcZvJ0TTNWlZauKO6SD3rPTYAAJRAANIhAsAAaefRc8nwhDRHgQ", // Lapenko ingener
        )
    }
}