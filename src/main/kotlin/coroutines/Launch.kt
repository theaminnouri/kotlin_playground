package org.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

object Launch {

    fun execute() = runBlocking {
        log("The first, parent, coroutine starts")
        launch {
            log("The second coroutine starts and is ready to be suspended")
            delay(100.milliseconds)

            log("The second coroutine is resumed")
        }
        launch {
            log("The third coroutine can run in the meantime")
        }
        log("The first coroutine has launched two more coroutines")
    }

    private var zeroTime = System.currentTimeMillis()

    fun log(message: Any?) =
        println(
            "${System.currentTimeMillis() - zeroTime} " +
                    "[${Thread.currentThread().name}] $message"
        )

}
