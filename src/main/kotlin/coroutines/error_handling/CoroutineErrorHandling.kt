package org.example.coroutines.error_handling


import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object CoroutineErrorHandling {
//    fun execute(): Unit = runBlocking {
//        try {
//            launch {
//                throw UnsupportedOperationException("Ouch!")
//            }
//        } catch (u: UnsupportedOperationException) {
//            println("Handled $u")
//        }
//// Exception in thread "main" java.lang.UnsupportedOperationException: Ouch!
////  at MyExampleKt$main$1$1.invokeSuspend(MyExample.kt:6)
////       ...
//    }

    //inside the coroutine
    private fun launchError(): Unit = runBlocking {
        launch {
            try {
                throw UnsupportedOperationException("Ouch!")
            } catch (u: UnsupportedOperationException) {
                println("Handled $u")
            }
        }

    }
// Handled java.lang.UnsupportedOperationException: Ouch!


    private fun asyncError(): Unit = runBlocking {
        val myDeferredInt: Deferred<Int> = async {
            throw UnsupportedOperationException("Ouch!")
        }
        try {
            val i: Int = myDeferredInt.await()
            println(i)
        } catch (u: UnsupportedOperationException) {
            println("Handled: $u")
        }
    }
//    this error handled in the builder but,
//    also it will propagate to the parent and crash whole application

    fun execute() {
        launchError()
        asyncError()
    }
}

