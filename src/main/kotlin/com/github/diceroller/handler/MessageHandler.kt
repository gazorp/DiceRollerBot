package com.github.diceroller.handler

import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.handlers.HandleMessage
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.extensions.filters.Filter

abstract class MessageHandler : Handler {

    abstract fun filter(): Filter

    abstract fun handleMessage(): HandleMessage

    final override fun handle(dispatcher: Dispatcher) = dispatcher.message(filter(), handleMessage())
}