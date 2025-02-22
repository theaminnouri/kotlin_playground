package org.example.coroutines.error_handling

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

object ErrorHandlingInADefaultJob {


    fun launch(): Unit = runBlocking {
        launch {
            try {
                while (true) {
                    println("Heartbeat!")
                    delay(500.milliseconds)
                }
            } catch (e: Exception) {
                println("Heartbeat terminated: $e")
                throw e
            }
        }
        launch {
            delay(1.seconds)
            throw UnsupportedOperationException("Ow!")
        }
    }

    fun async(): Unit = runBlocking {
        async {
            try {
                while (true) {
                    println("Heartbeat!")
                    delay(500.milliseconds)
                }
            } catch (e: Exception) {
                println("Heartbeat terminated: $e")
                throw e
            }
        }
        async {
            delay(1.seconds)
            throw UnsupportedOperationException("Ow!")
        }
    }

    fun handledException(): Unit = runBlocking {
        launch {
            try {
                while (true) {
                    println("Heartbeat!")
                    delay(500.milliseconds)
                }
            } catch (e: Exception) {
                println("Heartbeat terminated: $e")
                throw e
            }
        }
        launch {

            try {
                delay(1.seconds)
                throw UnsupportedOperationException("Ow!")
            } catch (u: UnsupportedOperationException) {
                println("Caught $u")
            }
        }
    }

    fun supervisorJob(): Unit = runBlocking {
        supervisorScope {
            launch {
                try {
                    while (true) {
                        println("Heartbeat!")
                        delay(500.milliseconds)
                    }
                } catch (e: Exception) {
                    println("Heartbeat terminated: $e")
                    throw e
                }
            }
            launch {
                delay(1.seconds)
                throw UnsupportedOperationException("Ow!")
            }
        }
    }





    fun execute() {
//        launch()
//        async()
//        handledException()
        supervisorJob()
    }
}