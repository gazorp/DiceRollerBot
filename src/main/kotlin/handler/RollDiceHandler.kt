package handler

import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.extensions.filters.Filter

abstract class RollDiceHandler(private val diceType: Int) : Handler {

    override fun handle(dispatcher: Dispatcher) {
        val filter = object : Filter {
            override fun Message.predicate(): Boolean = this.text?.startsWith("/dice$diceType") ?: false
        }

        dispatcher.message(filter) {
            bot.sendSticker(ChatId.fromId(update.message?.chat?.id!!), diceStickerSet().random(), replyMarkup = null)
        }
    }

    protected abstract fun diceStickerSet(): List<String>
}