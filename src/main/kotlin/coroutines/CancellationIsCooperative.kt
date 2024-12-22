package org.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

object CancellationIsCooperative {

    suspend fun doCpuHeavyWork(): Int {
        log("I'm doing work!")
        var counter = 0
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() < startTime + 500) {
            counter++
        }
        return counter
    }

    fun execute() {
        runBlocking {
            val myJob = launch {
                repeat(5) {
                    doCpuHeavyWork()
                }
            }
            delay(600.milliseconds)
            myJob.cancel()
        }
    }
}