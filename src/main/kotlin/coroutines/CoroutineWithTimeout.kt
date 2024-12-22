package org.example.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

object CoroutineWithTimeout {

    fun execute() {
        main()
    }

    suspend fun calculateSomething(): Int {
        delay(3.seconds)
        return 2 + 2
    }

    fun main() = runBlocking {
        try {
            val quickResult = withTimeout(500.milliseconds) {
                calculateSomething()
            }
            println(quickResult)
        } catch (ex: TimeoutCancellationException) {
            println(ex)
        }

        // null
        val slowResult = withTimeoutOrNull(5.seconds) {
            calculateSomething()
        }
        println(slowResult)
        // 4
    }
}