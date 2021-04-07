package handler

class Dice6RollMessageHandler : DiceRollMessageHandler(6) {

    override fun diceStickerSet(): List<String> = listOf(
        "CAACAgIAAxkBAAMTYGzRjIdY4oVcHCPZPh4jcdnk5ikAAiELAAKw1GhLexlYM5-lOIgeBA",  // d6-1
        "CAACAgIAAxkBAAMUYGzRqWsL2O7Wg0Xi5pl-wBBZKNsAAo4NAAL0fmlLWEX_rkUndJ8eBA",  // d6-2
        "CAACAgIAAxkBAAMVYGzRqvlX14ezNTmkZS7K4bAtqGIAAv4MAALH3WBLhrkXhxXjAAFeHgQ", // d6-3
        "CAACAgIAAxkBAAMWYGzRrKr9fVJFQPGFNCgvxDWIfbkAAnIMAAJOp2lLlTjwYVmuag4eBA",  // d6-4
        "CAACAgIAAxkBAAMXYGzRrvmx2rUvRX957VbBKfTB66wAAocLAALwymFLD7qBHFvtaoEeBA",  // d6-5
        "CAACAgIAAxkBAAMYYGzRsE1jCOMqz1tdTklTfVjplMUAAvsKAALRd2lLCKX8FhiXdPYeBA",  // d6-6
    )
}