package com.github.diceroller.handler

import com.github.kotlintelegrambot.Bot

class WrongMessageHandler(botName: String) : Handler {
    private val botMention: String = "@$botName"

    override fun suitable(command: Update): Boolean {
        return command.mentions.any { it == botMention } || command.commands.any { it.contains(botMention) }
    }

    override fun handle(bot: Bot, command: Update) {
        bot.sendSticker(command.chatId, funnyStickers.random(), replyMarkup = null)
    }

    companion object {
        private val funnyStickers = listOf(
            "CAACAgIAAxkBAAIBUWBuL0qk_bujKwJSei1qlMjQmx79AAI5AAMphsY9_bg97wvV_TseBA", // Lapenko sto
            "CAACAgIAAxkBAAIBUGBuLcZvJ0TTNWlZauKO6SD3rPTYAAJRAANIhAsAAaefRc8nwhDRHgQ", // Lapenko ingener
        )
    }
}