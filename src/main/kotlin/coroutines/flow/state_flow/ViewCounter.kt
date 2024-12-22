package org.example.coroutines.flow.state_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ViewCounter {

    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun increment() {
//        _counter.value++
        _counter.update { it + 1 }
    }

    companion object {

        fun execute() {
            val vc = ViewCounter()
            runBlocking(Dispatchers.Default) {
                repeat(10_000) {
                    launch {
                        vc.increment()
                    }
                }
            }
            println(vc.counter.value)
        }
    }
}