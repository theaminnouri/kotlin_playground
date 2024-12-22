package org.example.coroutines.flow

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

object DebounceOperator {

    val searchQuery = flow {
        emit("K")
        delay(100.milliseconds)
        emit("Ko")
        delay(200.milliseconds)
        emit("Kotl")
        delay(500.milliseconds)
        emit("Kotlin")
    }

    @OptIn(FlowPreview::class)
    fun executed() = runBlocking {
        searchQuery
            .debounce(250.milliseconds)
            .collect {
                log("Searching for $it")
            }
    }
}