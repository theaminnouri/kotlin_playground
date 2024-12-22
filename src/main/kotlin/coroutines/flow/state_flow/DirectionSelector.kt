package org.example.coroutines.flow.state_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.time.Duration.Companion.milliseconds

enum class Direction {
    LEFT,
    RIGHT
}

class DirectionSelector {
    private val _direction = MutableStateFlow(Direction.LEFT)
    val direction = _direction.asStateFlow()

    fun turn(d: Direction) {
        _direction.update { d }
    }

    companion object {

        fun execute() = runBlocking {
            val switch = DirectionSelector()
            launch {
                switch.direction.collect {
                    log("Direction now $it")
                }
            }
            delay(200.milliseconds)
            switch.turn(Direction.RIGHT)
            delay(200.milliseconds)
            switch.turn(Direction.LEFT)
            delay(200.milliseconds)
            switch.turn(Direction.LEFT)
        }
    }
}
