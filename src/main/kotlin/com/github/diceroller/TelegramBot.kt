package com.github.diceroller

import com.github.diceroller.handler.Handler
import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.entities.Update
import org.slf4j.LoggerFactory
import com.github.kotlintelegrambot.dispatcher.handlers.Handler as TelegramHandler

class TelegramBot(token: String, botName: String, handlers: List<Handler>) {

    private val messageParser = CommandParser(botName)
    private val logger = LoggerFactory.getLogger(javaClass)

    private val bot: Bot = bot {
        this.token = token

        val handler = object : TelegramHandler {
            override fun checkUpdate(update: Update): Boolean = true

            override fun handleUpdate(bot: Bot, update: Update) {
                val command = messageParser.parse(update)

                if (command == null) {
                    logger.info("Could not parse ${update.message}")
                    return
                }

                handlers.forEach {
                    if (it.suitable(command)) {
                        it.handle(bot, command)
                        logger.info("Handled: $command by ${it.javaClass.simpleName}")
                    }
                }
            }
        }

        dispatch { this.addHandler(handler) }

        logger.info("Dice Rolling bot is dispatching with ${handlers.size} handlers")
    }

    fun run() {
        bot.startPolling()
        logger.info("Starts polling")
    }
}