package org.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration.Companion.seconds

object MultiThread {

    fun execute() {
        increment1()
        increment2()
        increment3()
    }

    fun increment1() {
        runBlocking {
            launch(Dispatchers.Default) {
                var x = 0
                repeat(10_000) {
                    x++
                }
                println(x)
            }
        }
    }


    fun increment2() {
        runBlocking {
            var x = 0
            repeat(10_000) {
                launch(Dispatchers.Default) {
                    x++
                }
            }
            delay(1.seconds)
            println(x)
        }
    }

    fun increment3() = runBlocking {
        val mutex = Mutex()
        var x = 0
        repeat(10_000) {
            launch(Dispatchers.Default) {
                mutex.withLock {
                    x++
                }
            }
        }
        delay(1.seconds)
        println(x)
    }
}