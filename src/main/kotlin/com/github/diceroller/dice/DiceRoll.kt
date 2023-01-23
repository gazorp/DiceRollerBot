package com.github.diceroller.dice

data class DiceRoll(val type: DiceType, val value: Int, val stickers: Iterable<String>) {
    constructor(type: DiceType, value: Int, sticker: String) : this(type, value, listOf(sticker))
}
