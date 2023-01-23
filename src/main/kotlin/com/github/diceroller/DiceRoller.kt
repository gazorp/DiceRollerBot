package com.github.diceroller

import com.github.diceroller.dice.DiceRoller
import com.github.diceroller.equivocals.InMemoryEquivocalsCardRepository
import com.github.diceroller.handler.*

class DiceRoller {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size < 2) {
                throw Exception("Bot name and authentication token were not provided")
            }

            val botName = args[0]
            val token = args[1]

            val equivocalsCardsRepo = InMemoryEquivocalsCardRepository()

            val handlers: List<Handler> = listOf(
                DiceRollHandler(DiceRoller()),
                EquivocalsCommandHandler(equivocalsCardsRepo),
                WrongMessageHandler(botName),
            )

            val bot = TelegramBot(token, botName, handlers)

            bot.run()
        }
    }
}