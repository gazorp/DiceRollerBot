package com.github.diceroller.equivocals

interface EquivocalsCardRepository {
    fun getRandom(type: TaskType): Card?
}