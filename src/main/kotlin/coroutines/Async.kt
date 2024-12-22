package org.example.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

object Async {

    fun execute() = runBlocking {
        log("Starting the async computation")
        val myFirstDeferred = async { slowlyAddNumbers(2, 2) }
        val mySecondDeferred = async { slowlyAddNumbers(4, 4) }
        log("Waiting for the deferred value to be available")
        log("The first result: ${myFirstDeferred.await()}")
        log("The second result: ${mySecondDeferred.await()}")
    }

    suspend fun slowlyAddNumbers(a: Int, b: Int): Int {
        log("Waiting a bit before calculating $a + $b")
        delay(100.milliseconds * a)
        return a + b
    }


}