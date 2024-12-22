package org.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

object CancellationSpecialPlaces {

    suspend fun doWork() {
        delay(500.milliseconds)
        throw UnsupportedOperationException("Didn't work!")
    }

    fun execute() {
        runBlocking {
            withTimeoutOrNull(2.seconds) {
                while (true) {
                    try {
                        doWork()
                    } catch (e: Exception) {
                        println("Oops: ${e.message}")
                    }
                }
            }
        }
    }
}
