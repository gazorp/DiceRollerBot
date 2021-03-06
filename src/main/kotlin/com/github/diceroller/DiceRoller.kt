package com.github.diceroller

import com.github.diceroller.equivocals.InMemoryEquivocalsCardRepository
import com.github.diceroller.handler.*

class DiceRoller {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            if (args[0] != "--token" || args.size < 2) {
                throw Exception("Authentication token is not provided")
            }

            val token = args[1]

            val equivocalsCardsRepo = InMemoryEquivocalsCardRepository()

            val handlers = listOf(
                Dice4RollMessageHandler(),
                Dice6RollMessageHandler(),
                Dice8RollMessageHandler(),
                Dice100RollMessageHandler(),
                Dice10RollMessageHandler(),
                Dice12RollMessageHandler(),
                Dice20RollMessageHandler(),
                EquivocalsMessageHandler(equivocalsCardsRepo),
                WrongMessageHandler(),
            )

            val bot = TelegramBot(token, handlers)

            bot.run()
        }
    }
}