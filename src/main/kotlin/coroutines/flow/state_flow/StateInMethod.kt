package org.example.coroutines.flow.state_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking
import org.example.coroutines.flow.getTemperatures
import kotlin.time.Duration.Companion.milliseconds


object StateInMethod {

    fun execute() {
        val temps = getTemperatures()
        runBlocking {
            val tempState = temps.stateIn(this)
            println(tempState.value)
            delay(800.milliseconds)
            println(tempState.value)
        }
    }
}
