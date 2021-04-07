package handler

import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId

class WrongMessageHandler : Handler {

    override fun handle(dispatcher: Dispatcher) = dispatcher.message {
        bot.sendSticker(ChatId.fromId(update.message?.chat?.id!!), funnyStickers.random(), replyMarkup = null)
        update.consume()
    }

    companion object {
        private val funnyStickers = listOf(
            "CAACAgIAAxkBAAIBUWBuL0qk_bujKwJSei1qlMjQmx79AAI5AAMphsY9_bg97wvV_TseBA", // Lapenko sto
            "CAACAgIAAxkBAAIBUGBuLcZvJ0TTNWlZauKO6SD3rPTYAAJRAANIhAsAAaefRc8nwhDRHgQ", // Lapenko ingener
        )
    }
}