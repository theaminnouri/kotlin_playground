import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.yield
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds


class PlaygroundTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testDelay() = runTest {
        var x = 0
        launch {
            delay(500.milliseconds)
            x++
        }
        launch {
            delay(1.seconds)
            x++
        }
        println(currentTime) // 0

        delay(600.milliseconds)
        assertEquals(1, x)
        println(currentTime) // 600

        delay(500.milliseconds)
        assertEquals(2, x)
        println(currentTime) // 1100
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testDelay2() = runTest {
        var x = 0
        launch {
            log("first")
            x++
            launch {
                log("third")
                x++
            }
        }
        launch {
            log("second")
            delay(800.milliseconds)
            x++
        }
        println(currentTime)
        assertEquals(0, x)
        println("runCurrent")
        runCurrent()
        assertEquals(2, x)
        println("advanceUntilIdle")
        advanceUntilIdle()
        assertEquals(3, x)
    }

    private var zeroTime = System.currentTimeMillis()

    fun log(message: Any?) =
        println(
            "${System.currentTimeMillis() - zeroTime} " +
                    "[${Thread.currentThread().name}] $message"
        )

}