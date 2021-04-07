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
                Dice4RollMessageHandler(),
                Dice6RollMessageHandler(),
                Dice8RollMessageHandler(),
                Dice10RollMessageHandler(),
                Dice12RollMessageHandler(),
                Dice20RollMessageHandler(),
                Dice100RollMessageHandler(),
            )

            val bot = TelegramBot(token, handlers)

            bot.run()
        }
    }
}