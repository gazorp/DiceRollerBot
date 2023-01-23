package com.github.diceroller.handler

import com.github.diceroller.equivocals.Dice
import com.github.diceroller.equivocals.InMemoryEquivocalsCardRepository
import com.github.kotlintelegrambot.Bot

class EquivocalsCommandHandler(private val cards: InMemoryEquivocalsCardRepository) : Handler {

    override fun suitable(command: Update): Boolean = command.dice != null || command.command == Command.Equivocals

    override fun handle(bot: Bot, command: Update) {
        val dice: Dice = if (command.dice != null) {
            Thread.sleep(4000)
            Dice.values().first { it.value == command.dice }
        } else {
            Dice.values().random()
        }

        when (val card = cards.getRandom(dice)) {
            null -> {
                bot.sendMessage(command.chatId, "Карточки для \"${dice.value}\" закончились")
            }
            else -> {
                val msg = "Экивоки!\n" +
                    "Тема: ${card.theme.title}\n" +
                    "${card.type.dice.emoji}: ${card.type.description}\n\n" + card.task
                bot.sendMessage(command.chatId, msg)
            }
        }
    }
}