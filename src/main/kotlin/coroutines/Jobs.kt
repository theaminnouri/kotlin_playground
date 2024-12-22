package org.example.coroutines

import kotlinx.coroutines.*
import org.example.coroutines.Launch.log

object Jobs {

    fun execute() {
        child()
        parent()
    }

    fun child() = runBlocking(CoroutineName("A")) {
        log("A's job: ${coroutineContext.job}")
        launch(CoroutineName("B")) {
            log("B's job: ${coroutineContext.job}")
            log("B's parent: ${coroutineContext.job.parent}")
        }
        log("A's children: ${coroutineContext.job.children.toList()}")
    }

    fun parent() = runBlocking<Unit> { // coroutine#1
        log("A's job: ${coroutineContext.job}")
        coroutineScope {
            log("B's parent: ${coroutineContext.job.parent}") // A
            log("B's job: ${coroutineContext.job}") // C
            launch { //coroutine#2
                log("C's parent: ${coroutineContext.job.parent}") // B
            }
        }
    }
}