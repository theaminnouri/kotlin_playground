package org.example.coroutines.flow.error_handling

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class CommunicationException : Exception("Communication failed!")

object FlowRetry {
    val unreliableFlow = flow {
        println("Starting the flow!")

        repeat(10) { number ->
            if (Random.nextDouble() < 0.1) throw CommunicationException()
            emit(number)
        }
    }

    fun main() = runBlocking {
        unreliableFlow
            .retry(5) { cause ->
                println("\nHandled: $cause")
                cause is CommunicationException
            }
            .collect { number ->
                print("$number ")
            }
    }
}
