package org.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds


fun main() {
    runBlocking {
        val dbTask = launch {
            val db = DatabaseConnection()
//            delay(500.milliseconds)
//            db.write("I love coroutines!")
//            db.close()

            try {
                delay(500.milliseconds)
                db.write("I love coroutines!")
            } finally {
                db.close()
            }
        }
        delay(200.milliseconds)
        dbTask.cancel()
    }
    println("I leaked a resource!")
}

class DatabaseConnection : AutoCloseable {

    fun write(s: String) = println("writing $s!")

    override fun close() {
        println("Closing!")
    }
}
