package com.github.diceroller.handler

import com.github.diceroller.dice.DiceRoller
import com.github.diceroller.dice.DiceType
import com.github.kotlintelegrambot.Bot

class DiceRollHandler(private val diceRoller: DiceRoller) : Handler {

    override fun suitable(command: Update): Boolean = diceMap.contains(command.command)

    override fun handle(bot: Bot, command: Update) {
        val roll = diceRoller.roll(diceMap[command.command]!!)

        roll.stickers.forEach { sticker ->
            bot.sendSticker(command.chatId, sticker, replyMarkup = null)
        }
    }

    companion object {
        private val diceMap: Map<Command, DiceType> = mapOf(
            Command.DiceRoll4 to DiceType.Dice4,
            Command.DiceRoll6 to DiceType.Dice6,
            Command.DiceRoll8 to DiceType.Dice8,
            Command.DiceRoll10 to DiceType.Dice10,
            Command.DiceRoll12 to DiceType.Dice12,
            Command.DiceRoll20 to DiceType.Dice20,
            Command.DiceRoll100 to DiceType.Dice100,
        )
    }
}