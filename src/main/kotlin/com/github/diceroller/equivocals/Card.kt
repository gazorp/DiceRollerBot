package com.github.diceroller.equivocals

enum class CardTheme(val title: String) {
    ChertiYellow("Чертаново!"),
    ChertiPink("Чертаново!"),
    Sensations("Мир Ощущений"),
    HarryPotter("Гарри Поттер"),
    LoveAndAround("Любовь и ее конечности"),
    ;
}
data class Card(val theme: CardTheme, val type: TaskType, val description: String, val task: String)
