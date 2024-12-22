package org.example.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.coroutines.Launch.log
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

object ShareInMethod {


    fun celsiusToFahrenheit(celsius: Int) =
        celsius * 9.0 / 5.0 + 32.0

    fun execute() {
        val temps = getTemperatures()
        runBlocking {
//            launch {
//                temps.collect {
//                    log("$it Celsius")
//                }
//            }
//            launch {
//                temps.collect {
//                    log("${celsiusToFahrenheit(it)} Fahrenheit")
//                }
//            }

            val sharedTemps = temps.shareIn(this, SharingStarted.Lazily)
            launch {
                sharedTemps.collect {
                    log("$it Celsius")
                }
            }
            launch {
                sharedTemps.collect {
                    log("${celsiusToFahrenheit(it)} Fahrenheit")
                }
            }
        }
    }
}


fun querySensor(): Int = Random.nextInt(-10..30)

fun getTemperatures(): Flow<Int> {
    return flow {
        while (true) {
            emit(querySensor())
            delay(500.milliseconds)
        }
    }
}