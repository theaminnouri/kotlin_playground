package org.example.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds


object CoroutineGlobalScope {

    fun execute() {
        runBlocking {
            GlobalScope.launch {
                delay(1000.milliseconds)
                launch {
                    delay(250.milliseconds)
                    log("Grandchild done")
                }
                log("Child 1 done!")
            }
            GlobalScope.launch {
                delay(500.milliseconds)
                log("Child 2 done!")
            }
            log("Parent done!")
        }
    }

}
