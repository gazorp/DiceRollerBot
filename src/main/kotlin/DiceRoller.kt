import handler.*

class DiceRoller {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            if (args[0] != "--token" || args.size < 2) {
                throw Exception("Authentication token is not provided")
            }

            val token = args[1]

            val handlers = listOf(
                RollDice4Handler(),
                RollDice6Handler(),
                RollDice8Handler(),
                RollDice10Handler(),
                RollDice12Handler(),
                RollDice20Handler(),
            )

            val bot = TelegramBot(token, handlers)

            bot.run()
        }
    }
}