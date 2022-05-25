package com.github.diceroller.handler

import com.github.kotlintelegrambot.dispatcher.Dispatcher

interface Handler {

    fun handle(dispatcher: Dispatcher)
}