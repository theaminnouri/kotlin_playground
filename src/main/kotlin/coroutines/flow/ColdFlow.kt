package org.example.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

object ColdFlow {

    fun execute() {
        val letters = flow {
            log("Emitting A!")
            emit("A")
            delay(200.milliseconds)
            log("Emitting B!")
            emit("B")
        }

        runBlocking {
            letters.collect {
                log("(1) Collecting $it")
                delay(500.milliseconds)
            }
            letters.collect {
                log("(2) Collecting $it")
                delay(500.milliseconds)
            }
        }

    }
}
