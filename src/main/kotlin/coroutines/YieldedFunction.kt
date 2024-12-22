package org.example.coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import org.example.coroutines.Launch.log

object YieldedFunction {

    suspend fun doCpuHeavyWork(): Int {
        log("I'm doing work!")
        var counter = 0
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() < startTime + 500) {
            counter++
        }
//        delay(10)
        yield()
        return counter
    }

    fun execute() {
        runBlocking {
            launch {
                repeat(3) {
                    doCpuHeavyWork()
//                    delay(10)
                }
            }
            launch {
                repeat(3) {
                    doCpuHeavyWork()
//                    delay(10)
                }
            }
        }
    }
}
