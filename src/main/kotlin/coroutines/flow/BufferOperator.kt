package org.example.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

object BufferOperator {

    private fun getAllUserIds(): Flow<Int> {
        return flow {
            repeat(3) {
                delay(200.milliseconds) // Database latency
                log("Emitting!")
                emit(it)
            }
        }
    }


    private suspend fun getProfileFromNetwork(id: Int): String {
        delay(2.seconds) // Network latency
        return "Profile[$id]"
    }


    fun execute() {
        val ids = getAllUserIds()
        runBlocking {
            ids
                //run with and without buffer
                .buffer(3)
                .map { getProfileFromNetwork(it) }
                .collect { log("Got $it") }
        }
    }

}
