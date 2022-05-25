package com.github.diceroller.equivocals

enum class CardTheme {
    ChertiYellow,
    ChertiPink,
    Sensations,
    ;

    fun title(): String = when (this) {
        ChertiYellow, ChertiPink -> "Чертаново!"
        Sensations -> "Мир Ощущений"
    }
}
data class Card(val theme: CardTheme, val type: TaskType, val description: String, val task: String)
