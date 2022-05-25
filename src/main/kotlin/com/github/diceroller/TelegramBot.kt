package com.github.diceroller

import com.github.diceroller.handler.Handler
import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.message
import org.slf4j.LoggerFactory

class TelegramBot(token: String, handlers: List<Handler>) {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val bot: Bot = bot {
        this.token = token

        dispatch {
            listOf(loggingHandler()).plus(handlers).forEach { it.handle(this) }
        }
        logger.info("Dice Rolling bot is dispatching with ${handlers.size} handlers")
    }

    private fun loggingHandler(): Handler = object : Handler {
        override fun handle(dispatcher: Dispatcher) = dispatcher.message {
            logger.info("[${message.chat.username ?: message.chat.title}][${message.from?.firstName}]: ${message.text} $message")
        }
    }

    fun run(): Unit = bot.startPolling().also { logger.info("Starts polling") }
}
