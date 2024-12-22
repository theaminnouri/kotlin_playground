package org.example.coroutines.error_handling

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object TopLevelExceptionHandler {

    private val topLevelHandler = CoroutineExceptionHandler { _, e ->
        println("[TOP] ${e.message}")
    }

    private val intermediateHandler = CoroutineExceptionHandler { _, e ->
        println("[INTERMEDIATE] ${e.message}")
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun execute() {
        GlobalScope.launch(topLevelHandler) {
            launch(intermediateHandler) {
                throw UnsupportedOperationException("Ouch!")
            }
        }
        Thread.sleep(1000)
    }

}
