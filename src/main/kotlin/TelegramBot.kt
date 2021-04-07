import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import handler.Handler

class TelegramBot(token: String, handlers: List<Handler>) {

    private val bot: Bot = bot {
        this.token = token

        dispatch {
            handlers.forEach { it.handle(this) }
        }
    }

    fun run(): Unit = bot.startPolling()
}
