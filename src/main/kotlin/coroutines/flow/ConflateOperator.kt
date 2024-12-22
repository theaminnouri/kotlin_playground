package org.example.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.seconds

object ConflateOperator {

    fun execute() {
        runBlocking {
            val temps = getTemperatures()
            temps
                .onEach {
                    log("Read $it from sensor")
                }
                .conflate()
                .collect {
                    log("Collected $it")
                    delay(1.seconds)
                }
        }
    }
}