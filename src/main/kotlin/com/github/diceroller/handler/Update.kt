package com.github.diceroller.handler

import com.github.kotlintelegrambot.entities.ChatId

data class Update(
    val chatId: ChatId,
    val command: Command? = null,
    val text: String? = null,
    val mentions: List<String> = emptyList(),
    val commands: List<String> = emptyList(),
    val dice: Int? = null,
)