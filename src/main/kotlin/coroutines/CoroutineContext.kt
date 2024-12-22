package org.example.coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.coroutines.coroutineContext

object CoroutineContext {

    fun execute2() {
        runBlocking(Dispatchers.Default) {
            log(coroutineContext)
            launch {
                log(coroutineContext)
                launch(Dispatchers.IO + CoroutineName("mine")) {
                    log(coroutineContext)
                }
            }
        }
    }

    fun execute() {
        runBlocking {
            introspect()
        }
        runBlocking(Dispatchers.IO + CoroutineName("Coolroutine")) {
            introspect()
        }
    }

    private suspend fun introspect() {
        log(coroutineContext)
    }

}
