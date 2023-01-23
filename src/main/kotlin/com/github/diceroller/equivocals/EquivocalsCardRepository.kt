package com.github.diceroller.equivocals

interface EquivocalsCardRepository {

    fun getRandom(dice: Dice): Card?
}