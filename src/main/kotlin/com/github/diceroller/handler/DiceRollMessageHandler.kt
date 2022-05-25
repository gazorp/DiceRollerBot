package com.github.diceroller.handler

import com.github.kotlintelegrambot.dispatcher.handlers.HandleMessage
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message
import com.github.kotlintelegrambot.extensions.filters.Filter

abstract class DiceRollMessageHandler(private val diceType: Int) : MessageHandler() {

    override fun filter(): Filter = object : Filter {
        override fun Message.predicate(): Boolean {
            val text = this.text ?: ""

            return text == "/roll$diceType" || text == "/roll$diceType@PerfectRollBot"
        }
    }

    override fun handleMessage(): HandleMessage = {
        bot.sendSticker(ChatId.fromId(update.message?.chat?.id!!), diceStickerSet().random(), replyMarkup = null)
        update.consume()
    }

    protected abstract fun diceStickerSet(): List<String>
}