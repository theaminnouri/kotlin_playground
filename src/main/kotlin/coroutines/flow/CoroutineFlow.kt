package org.example.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

object CoroutineFlow {

    fun createValues(): Flow<Int> {
        return flow {
            emit(1)
            delay(1000.milliseconds)
            emit(2)
            delay(1000.milliseconds)
            emit(3)
            delay(1000.milliseconds)
        }
    }
    fun execute() = runBlocking {
        val myFlowOfValues = createValues()
        myFlowOfValues.collect { log(it) }
    }
}


