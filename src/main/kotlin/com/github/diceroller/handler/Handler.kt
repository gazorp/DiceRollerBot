package com.github.diceroller.handler

import com.github.kotlintelegrambot.Bot

interface Handler {

    fun suitable(command: Update): Boolean

    fun handle(bot: Bot, command: Update)
}