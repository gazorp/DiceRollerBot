package com.github.diceroller.dice

import kotlin.random.Random

class DiceRoller {

    private val rollsByDice: Map<DiceType, List<DiceRoll>> = rolls.groupBy { it.type }

    fun roll(type: DiceType): DiceRoll = when (type) {
        DiceType.Dice100 -> roll100()
        else -> rollsByDice[type]!!.random()
    }

    private fun roll100(): DiceRoll {
        val roll = Random.nextInt(1, 100)

        val dozens = roll / 10
        val units = (roll - (dozens * 10)).run { if (this == 0) 10 else this }

        val stickers = listOf(dozens, units)
            .mapNotNull { value -> rollsByDice[DiceType.Dice10]?.firstOrNull { it.value == value } }
            .flatMap { it.stickers }

        return DiceRoll(DiceType.Dice100, roll, stickers)
    }

    companion object {
        private val rolls = listOf(
            DiceRoll(DiceType.Dice4, 1, "CAACAgIAAxkBAAMDYGzOEoKtEeyiCzJUzkmPxwobN8cAAvAKAAJqVGhLg4WWzwEIDmEeBA"),
            DiceRoll(DiceType.Dice4, 2, "CAACAgIAAxkBAAMEYGzOY8p3t_up4N2Ro3UGjQkZi1oAAngNAAJ15mBLm77Lf6pRURseBA"),
            DiceRoll(DiceType.Dice4, 3, "CAACAgIAAxkBAAMFYGzOcBKR1ZtUI-uF8kIxPa-PRIwAAuQOAAJrvGlLEWv-HNjWODAeBA"),
            DiceRoll(DiceType.Dice4, 4, "CAACAgIAAxkBAAMGYGzOhzgvfYuw9oeWqdznE39FSB0AAuMMAAJOx2lLLOfjRNuc4vYeBA"),

            DiceRoll(DiceType.Dice6, 1, "CAACAgIAAxkBAAMTYGzRjIdY4oVcHCPZPh4jcdnk5ikAAiELAAKw1GhLexlYM5-lOIgeBA"),
            DiceRoll(DiceType.Dice6, 2, "CAACAgIAAxkBAAMUYGzRqWsL2O7Wg0Xi5pl-wBBZKNsAAo4NAAL0fmlLWEX_rkUndJ8eBA"),
            DiceRoll(DiceType.Dice6, 3, "CAACAgIAAxkBAAMVYGzRqvlX14ezNTmkZS7K4bAtqGIAAv4MAALH3WBLhrkXhxXjAAFeHgQ"),
            DiceRoll(DiceType.Dice6, 4, "CAACAgIAAxkBAAMWYGzRrKr9fVJFQPGFNCgvxDWIfbkAAnIMAAJOp2lLlTjwYVmuag4eBA"),
            DiceRoll(DiceType.Dice6, 5, "CAACAgIAAxkBAAMXYGzRrvmx2rUvRX957VbBKfTB66wAAocLAALwymFLD7qBHFvtaoEeBA"),
            DiceRoll(DiceType.Dice6, 6, "CAACAgIAAxkBAAMYYGzRsE1jCOMqz1tdTklTfVjplMUAAvsKAALRd2lLCKX8FhiXdPYeBA"),

            DiceRoll(DiceType.Dice8, 1, "CAACAgIAAxkBAAMbYGzSbBASjs8DuXko2EhrsAZ8_cgAAtUPAAJNrmhL-uti3_1xlMseBA"),
            DiceRoll(DiceType.Dice8, 2, "CAACAgIAAxkBAAMcYGzSbtvMfCrAwimxZxe1rogk1-oAAnkLAAJXV2hL0t6nULVe0NEeBA"),
            DiceRoll(DiceType.Dice8, 3, "CAACAgIAAxkBAAMdYGzScKZS2vrZ62pbklyj3sdEQHoAAoIMAAI9umBLG4GAhQ2gOzAeBA"),
            DiceRoll(DiceType.Dice8, 4, "CAACAgIAAxkBAAMeYGzScQADeTG8_y1XEgVp4M-NZgACxA4AAuMUYEvVs1kf1gSq6R4E"),
            DiceRoll(DiceType.Dice8, 5, "CAACAgIAAxkBAAMfYGzSc-CegXjYCHkQz9Xp4w2h1pkAAooNAALsPWBLZvTr_i-5gTgeBA"),
            DiceRoll(DiceType.Dice8, 6, "CAACAgIAAxkBAAMgYGzSdHuOqNgQAAG9SWTMdjXVLoI-AAIFCgACDWVpS7hKwzOiSlTaHgQ"),
            DiceRoll(DiceType.Dice8, 7, "CAACAgIAAxkBAAMhYGzSdpu7BtiBKuF0wpZ4RcsWXRgAApUNAAL8lmhLWQYhw9cWFHweBA"),
            DiceRoll(DiceType.Dice8, 8, "CAACAgIAAxkBAAMiYGzSeEK1vel1KkWUnjB95lnISCgAAvUMAAJW-GhLZzUnXIEUTe0eBA"),

            DiceRoll(DiceType.Dice10, 1, "CAACAgIAAxkBAAM8YGzVH7TgwUTK_KIoXaYeKfkkTzYAAogOAAJkS2hL4YUyyx8dXM4eBA"),
            DiceRoll(DiceType.Dice10, 2, "CAACAgIAAxkBAAM9YGzVIA9NrvTBFUaNQl8wZpa7lp0AAqsMAAInImBLzrwtSqbP-SMeBA"),
            DiceRoll(DiceType.Dice10, 3, "CAACAgIAAxkBAAM-YGzVItRfIwl0q_2_krY5wcxrE34AAlkLAALNnWhLbMtVcOhuhqIeBA"),
            DiceRoll(DiceType.Dice10, 4, "CAACAgIAAxkBAAM_YGzVJBA0bHVm6xN8fvf6ifyYlNsAAhEMAAIG4mlLbuLFoTDSnnseBA"),
            DiceRoll(DiceType.Dice10, 5, "CAACAgIAAxkBAANAYGzVJppMLAg-Se805UUGWc-XjrIAApELAAIDNmlLYDazWSruhT8eBA"),
            DiceRoll(DiceType.Dice10, 6, "CAACAgIAAxkBAANBYGzVJ2-NoIOY9A1AWRjoGCuXVuwAAvcLAALNB2lLDeez3cjATPIeBA"),
            DiceRoll(DiceType.Dice10, 7, "CAACAgIAAxkBAANCYGzVKU7l0PcV1YZ-yYMnkv_hUHoAAsYLAAKhh2FLBgZ7qb6oIjAeBA"),
            DiceRoll(DiceType.Dice10, 8, "CAACAgIAAxkBAANDYGzVKk6dvYN0LiX2q653FizZXvUAAmsMAALX8mhLnAABnCKjDUJeHgQ"),
            DiceRoll(DiceType.Dice10, 9, "CAACAgIAAxkBAANEYGzVLIHA4LewyiVgp1WQGMauj0IAApAMAAIiM2lLkMpS4HB5IJ4eBA"),
            DiceRoll(DiceType.Dice10, 10, "CAACAgIAAxkBAANFYGzVLdhztdr-F39xf0IYGKyfkaIAAuMMAAL8dWhLMX1qnYAgGjMeBA"),

            DiceRoll(DiceType.Dice12, 1, "CAACAgIAAxkBAANIYGzV4Rluagrba1qedrOK9nigO_8AAiUOAAJLmWFLSULIV7FGzHoeBA"),
            DiceRoll(DiceType.Dice12, 2, "CAACAgIAAxkBAANJYGzV49Je5J6ssy4PHhFepDrvq78AAkYPAAJhkGlL8Mc9o-YvIikeBA"),
            DiceRoll(DiceType.Dice12, 3, "CAACAgIAAxkBAANKYGzV5DIjBRPS5Bv_dqu7Z_69MWkAAnMNAAKY9mhLVOsmfBSP8cceBA"),
            DiceRoll(DiceType.Dice12, 4, "CAACAgIAAxkBAANLYGzV5kaxro4kHqUxIWWZbD23hPQAArUKAAJdsGBLPkh-fEWgXSQeBA"),
            DiceRoll(DiceType.Dice12, 5, "CAACAgIAAxkBAANMYGzV6H113FTyQzUJpsDG1XdGtCgAAuoLAAKrsGFL60mXA1xf1YAeBA"),
            DiceRoll(DiceType.Dice12, 6, "CAACAgIAAxkBAANNYGzV6Te7UcULc88gemza-E9IMpQAAk8MAAKov2FLHXSbu_kqQyAeBA"),
            DiceRoll(DiceType.Dice12, 7, "CAACAgIAAxkBAANOYGzV6yTnkw9yC-AuDRnsTlwvrOkAAikMAALmrmBL7MClEXojIw0eBA"),
            DiceRoll(DiceType.Dice12, 8, "CAACAgIAAxkBAANPYGzV7M7-g9AHXSVYtVDNikCUo4QAAo8MAALw-2BL3MmVbsn7YAoeBA"),
            DiceRoll(DiceType.Dice12, 9, "CAACAgIAAxkBAANQYGzV763FLS4xHLeH9Ys2pzMWr2oAAroMAAK9X2lLx_Si6WprOKYeBA"),
            DiceRoll(DiceType.Dice12, 10, "CAACAgIAAxkBAANRYGzV8bUlDgMHq985pv6oJ-1Zxr0AAqQKAALJZmlLOQt9G-uooVkeBA"),
            DiceRoll(DiceType.Dice12, 11, "CAACAgIAAxkBAANSYGzV8lvS9obbKbsxBIdiZCqQkdYAAj4NAAJsX2FLOvh8iHCxXWkeBA"),
            DiceRoll(DiceType.Dice12, 12, "CAACAgIAAxkBAAOxYGzgS-ipZlNi6gHQ3SErm0RoE1AAAi8MAAJYC2hLDxRcXyQAAe5uHgQ"),

            DiceRoll(DiceType.Dice20, 1, "CAACAgIAAxkBAAO9YGzi_sIgzkrIohAEyqxw-RRcBp8AAh8OAAJwu1lLlDCE8tCu-L4eBA"),
            DiceRoll(DiceType.Dice20, 2, "CAACAgIAAxkBAAO-YGzjFG7_1TjltRdOBpXM5jUvgEgAAowOAAKR6FhLq5spL79f3IweBA"),
            DiceRoll(DiceType.Dice20, 3, "CAACAgIAAxkBAAO_YGzjFTb5JKGsvQf4J5aQIG-cUi4AAioNAALPxFhL6I8yvOUE3D0eBA"),
            DiceRoll(DiceType.Dice20, 4, "CAACAgIAAxkBAAPAYGzjFz70mZ9lif7RTEyRGZDxqmkAAtQKAAJj52FLdmeVLlEJizAeBA"),
            DiceRoll(DiceType.Dice20, 5, "CAACAgIAAxkBAAPBYGzjGXmRPMee9LbriaVgpsB0eVoAAjkMAAIXaFlLqz-BFlL0Gg4eBA"),
            DiceRoll(DiceType.Dice20, 6, "CAACAgIAAxkBAAPCYGzjG3cZ-XC1RdyXq-y12gAB7ROhAAILDQACGmFYSwuc4miw3oH9HgQ"),
            DiceRoll(DiceType.Dice20, 7, "CAACAgIAAxkBAAPDYGzjHCro9gnC8pkzQYw7y2TnH1cAAt4MAAK0b1lLjDFOQYpA_1UeBA"),
            DiceRoll(DiceType.Dice20, 8, "CAACAgIAAxkBAAPEYGzjHgahlrrk24_3AAF1xvHWXgO1AAJsDQACYkdgS08uoAiYs2TMHgQ"),
            DiceRoll(DiceType.Dice20, 9, "CAACAgIAAxkBAAPFYGzjIB-zVzehwbNe503SGnMYfTkAAqkPAAO1YUvI6nxZxCkaQB4E"),
            DiceRoll(DiceType.Dice20, 10, "CAACAgIAAxkBAAPGYGzjIQeAtjDt_ywRF8JevLVAW7YAApoLAAKt21hLSYdRUhnyKPkeBA"),
            DiceRoll(DiceType.Dice20, 11, "CAACAgIAAxkBAAPHYGzjI8Du685-D3FyG_914Ej7mwUAAmYOAAIzvFhLPmfkKx3CSFAeBA"),
            DiceRoll(DiceType.Dice20, 12, "CAACAgIAAxkBAAPIYGzjJoQ2ffGM466UVYS_p-w1pP0AAscKAALMxVlLcbmudYT7o0AeBA"),
            DiceRoll(DiceType.Dice20, 13, "CAACAgIAAxkBAAPJYGzjJ1Kjnsef4OMKLx3XjyJfjY0AAkAMAAKa6FlLX5QUTeiflAseBA"),
            DiceRoll(DiceType.Dice20, 14, "CAACAgIAAxkBAAPKYGzjKXjfZWPgLlV52stA2V1-SoEAAh4NAAJ3gVlLmldU77vAhC8eBA"),
            DiceRoll(DiceType.Dice20, 15, "CAACAgIAAxkBAAPLYGzjKybupxtqvsVWpP3B57GzcZ8AAmkLAAJVAVlLdPPa8-y43VIeBA"),
            DiceRoll(DiceType.Dice20, 16, "CAACAgIAAxkBAAPMYGzjLOq6TCJBwys7aKVhTC03XTsAApQNAAJmkVlLquU8JRkoeoEeBA"),
            DiceRoll(DiceType.Dice20, 17, "CAACAgIAAxkBAAPNYGzjLmLsM2RJ-FYfW9wichvqenQAAiwJAALm_llLQD0ZHtDvbFgeBA"),
            DiceRoll(DiceType.Dice20, 18, "CAACAgIAAxkBAAPOYGzjL7J2R_O8BGDCby7xA33GrkAAAhMNAAJduFlLRlm4hbf6q3MeBA"),
            DiceRoll(DiceType.Dice20, 19, "CAACAgIAAxkBAAPPYGzjMSnpIxMYZlhoJEwy2RNQpssAAgIMAAJzbllLvaNeQ1hyCdoeBA"),
            DiceRoll(DiceType.Dice20, 20, "CAACAgIAAxkBAAPQYGzjMos26f1celo1u7Fz4cRTejcAAq0KAAL6y2BL6dFWYDgSSMQeBA"),
        )
    }
}