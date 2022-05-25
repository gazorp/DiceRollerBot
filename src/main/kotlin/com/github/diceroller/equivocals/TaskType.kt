package com.github.diceroller.equivocals

enum class TaskType(val dice: Int) {
    BACKWARDS(1),
    WORDS(2),
    DRAWING(3),
    CROCODILE(4),
    YES_NO_PUZZLE(5),
    EQUIVOCALS(6),
    ;

    fun emoji(): String = when (this) {
        BACKWARDS -> "1️⃣"
        WORDS -> "2️⃣"
        DRAWING -> "3️⃣"
        CROCODILE -> "4️⃣"
        YES_NO_PUZZLE -> "5️⃣"
        EQUIVOCALS -> "6️⃣"
    }
}