package org.example.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.example.coroutines.Launch.log
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

class RadioStation {
    private val _messageFlow = MutableSharedFlow<Int>()
    val messageFlow = _messageFlow.asSharedFlow()

    fun beginBroadcasting(scope: CoroutineScope) {
        scope.launch {
            while (true) {
                delay(500.milliseconds)
                val number = Random.nextInt(0..10)
                log("Emitting $number!")
                _messageFlow.emit(number)
            }
        }
    }

    companion object {

        fun execute() {
            val radioStation = RadioStation()
            radioStation.beginBroadcasting(CoroutineScope(Dispatchers.IO))
            runBlocking {
                radioStation.messageFlow.collect {
                    println(it)
                }
            }
        }
    }
}