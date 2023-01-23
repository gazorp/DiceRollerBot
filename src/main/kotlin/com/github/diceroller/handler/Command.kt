package com.github.diceroller.handler

enum class Command(val text: String) {
    DiceRoll4("/roll4"),
    DiceRoll6("/roll6"),
    DiceRoll8("/roll8"),
    DiceRoll10("/roll10"),
    DiceRoll12("/roll12"),
    DiceRoll20("/roll20"),
    DiceRoll100("/roll100"),
    Equivocals("/equivocals"),
    ;

    companion object {
        private val diceRolls: List<Command> = listOf(
            DiceRoll4,
            DiceRoll6,
            DiceRoll8,
            DiceRoll10,
            DiceRoll12,
            DiceRoll20,
            DiceRoll100,
        )

        fun diceRolls(): List<Command> = diceRolls
    }
}
