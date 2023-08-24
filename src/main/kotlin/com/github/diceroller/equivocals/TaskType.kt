package com.github.diceroller.equivocals

enum class TaskType(val dice: Dice, val description: String) {
    BACKWARDS(Dice.One, "Наоборот"),
    WORDS(Dice.Two, "Объясни словами"),
    DRAWING(Dice.Three, "Нарисуй"),
    CROCODILE(Dice.Four, "Покажи жестами"),
    YES_NO_PUZZLE(Dice.Five, "Да/Нет"),
    DRAW_BLIND(Dice.Six, "Нарисуй с закрытыми глазами"),
    THING(Dice.Six, "Тварь/Штука"),
    EXPLAIN_AS_DUMB(Dice.Six, "Объясни как умственно отсталый"),
    EXPLAIN_BRANDS(Dice.Six, "Объясни бренды"),
    HUMMING(Dice.Six, "Напой песню без слов"),
    EXPLAIN_GAMES(Dice.Six, "Объясни игры"),
    SOUND_ONLY(Dice.Six, "Объясни звуками"),
    SING_SONGS(Dice.Six, "Спой песни исполителей"),
    EXPLAIN_MOVIES(Dice.Six, "Объясни фильмы"),
    EQUIVOCALS_BACKWARDS_MEANING(Dice.Six, "Наоборот и значение"),
    EQUIVOCALS_CROCODILE(Dice.Six, "Покажи жестами"),
    EQUIVOCALS_WORDS(Dice.Six, "Объясни словами"),
}
