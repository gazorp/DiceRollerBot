import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.Dispatcher
import com.github.kotlintelegrambot.dispatcher.message
import handler.Handler
import org.slf4j.LoggerFactory

class TelegramBot(token: String, handlers: List<Handler>) {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val bot: Bot = bot {
        this.token = token

        dispatch {
            listOf(loggingHandler()).plus(handlers).forEach { it.handle(this) }
        }
    }

    private fun loggingHandler(): Handler = object : Handler {
        override fun handle(dispatcher: Dispatcher) = dispatcher.message {
            logger.info("[${message.chat.username ?: message.chat.firstName}]: ${message.text}")
        }
    }

    fun run(): Unit = bot.startPolling()
}
