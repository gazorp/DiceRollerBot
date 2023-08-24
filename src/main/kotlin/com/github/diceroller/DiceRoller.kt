package com.github.diceroller

import com.github.diceroller.dice.DiceRoller
import com.github.diceroller.encryption.VigenereEncryptor
import com.github.diceroller.equivocals.InMemoryEquivocalsCardRepository
import com.github.diceroller.handler.*

class DiceRoller {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val botName = args.getOrElse(0) { throw Exception("Bot name is required") }
            val token = args.getOrElse(1) { throw Exception("Authentication token is required") }
            val encryptionKey = args.getOrElse(2) { throw Exception("Encryption key is required") }

            val equivocalsCardsRepo = InMemoryEquivocalsCardRepository(VigenereEncryptor(encryptionKey))

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