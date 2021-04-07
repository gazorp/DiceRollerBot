package handler

class RollDice4Handler : RollDiceHandler(4) {

    override fun diceStickerSet(): List<String> = listOf(
        "CAACAgIAAxkBAAMDYGzOEoKtEeyiCzJUzkmPxwobN8cAAvAKAAJqVGhLg4WWzwEIDmEeBA", // d4-1
        "CAACAgIAAxkBAAMEYGzOY8p3t_up4N2Ro3UGjQkZi1oAAngNAAJ15mBLm77Lf6pRURseBA", // d4-2
        "CAACAgIAAxkBAAMFYGzOcBKR1ZtUI-uF8kIxPa-PRIwAAuQOAAJrvGlLEWv-HNjWODAeBA", // d4-3
        "CAACAgIAAxkBAAMGYGzOhzgvfYuw9oeWqdznE39FSB0AAuMMAAJOx2lLLOfjRNuc4vYeBA", // d4-4
    )
}