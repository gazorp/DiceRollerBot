package com.github.diceroller.handler

class Dice10RollMessageHandler : DiceRollMessageHandler(10) {

    override fun diceStickerSet(): List<String> = listOf(
        "CAACAgIAAxkBAAM8YGzVH7TgwUTK_KIoXaYeKfkkTzYAAogOAAJkS2hL4YUyyx8dXM4eBA",  // d10-1
        "CAACAgIAAxkBAAM9YGzVIA9NrvTBFUaNQl8wZpa7lp0AAqsMAAInImBLzrwtSqbP-SMeBA",  // d10-2
        "CAACAgIAAxkBAAM-YGzVItRfIwl0q_2_krY5wcxrE34AAlkLAALNnWhLbMtVcOhuhqIeBA",  // d10-3
        "CAACAgIAAxkBAAM_YGzVJBA0bHVm6xN8fvf6ifyYlNsAAhEMAAIG4mlLbuLFoTDSnnseBA",  // d10-4
        "CAACAgIAAxkBAANAYGzVJppMLAg-Se805UUGWc-XjrIAApELAAIDNmlLYDazWSruhT8eBA",  // d10-5
        "CAACAgIAAxkBAANBYGzVJ2-NoIOY9A1AWRjoGCuXVuwAAvcLAALNB2lLDeez3cjATPIeBA",  // d10-6
        "CAACAgIAAxkBAANCYGzVKU7l0PcV1YZ-yYMnkv_hUHoAAsYLAAKhh2FLBgZ7qb6oIjAeBA",  // d10-7
        "CAACAgIAAxkBAANDYGzVKk6dvYN0LiX2q653FizZXvUAAmsMAALX8mhLnAABnCKjDUJeHgQ", // d10-8
        "CAACAgIAAxkBAANEYGzVLIHA4LewyiVgp1WQGMauj0IAApAMAAIiM2lLkMpS4HB5IJ4eBA",  // d10-9
        "CAACAgIAAxkBAANFYGzVLdhztdr-F39xf0IYGKyfkaIAAuMMAAL8dWhLMX1qnYAgGjMeBA",  // d10-10
    )
}