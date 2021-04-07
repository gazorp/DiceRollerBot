package handler

class Dice8RollMessageHandler : DiceRollMessageHandler(8) {

    override fun diceStickerSet(): List<String> = listOf(
        "CAACAgIAAxkBAAMbYGzSbBASjs8DuXko2EhrsAZ8_cgAAtUPAAJNrmhL-uti3_1xlMseBA",  // d8-1
        "CAACAgIAAxkBAAMcYGzSbtvMfCrAwimxZxe1rogk1-oAAnkLAAJXV2hL0t6nULVe0NEeBA",  // d8-2
        "CAACAgIAAxkBAAMdYGzScKZS2vrZ62pbklyj3sdEQHoAAoIMAAI9umBLG4GAhQ2gOzAeBA",  // d8-3
        "CAACAgIAAxkBAAMeYGzScQADeTG8_y1XEgVp4M-NZgACxA4AAuMUYEvVs1kf1gSq6R4E",    // d8-4
        "CAACAgIAAxkBAAMfYGzSc-CegXjYCHkQz9Xp4w2h1pkAAooNAALsPWBLZvTr_i-5gTgeBA",  // d8-5
        "CAACAgIAAxkBAAMgYGzSdHuOqNgQAAG9SWTMdjXVLoI-AAIFCgACDWVpS7hKwzOiSlTaHgQ", // d8-6
        "CAACAgIAAxkBAAMhYGzSdpu7BtiBKuF0wpZ4RcsWXRgAApUNAAL8lmhLWQYhw9cWFHweBA",  // d8-7
        "CAACAgIAAxkBAAMiYGzSeEK1vel1KkWUnjB95lnISCgAAvUMAAJW-GhLZzUnXIEUTe0eBA",  // d8-8
    )
}