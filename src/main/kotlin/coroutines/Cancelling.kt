package org.example.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

object Cancelling {

    fun execute() = runBlocking {
        var grandGrandChild: Job? = null
        val job = launch {
            launch {
                launch {
                    grandGrandChild = launch {
                        log("I'm started")
                        delay(500.milliseconds)
                        log("I'm done!")
                    }
                    launch {
                        log("I'm started")
                        delay(500.milliseconds)
                        log("I'm done!")
                    }
                }
            }
        }
        delay(200.milliseconds)
        job.cancel()
//        grandGrandChild?.cancel()
    }

}
