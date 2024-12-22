package org.example.coroutines.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

object FlowOperators {

    suspend fun process(flow: Flow<Int>) {
        flow
            .onEmpty {
                println("Nothing - emitting default value!")
                emit(0)
            }
            .onStart {
                println("Starting!")
            }
            .onEach {
                println("On $it!")
            }
            .onCompletion {
                println("Done!")
            }
            .collect()
    }

    fun execute() {
        runBlocking {
            process(flowOf(1, 2, 3))
            // Starting!
            // On 1!
            // On 2!
            // On 3!
            // Done!
            process(flowOf())
            // Starting!
            // Nothing - emitting default value!
            // On 0!
            // Done!
        }
    }

}