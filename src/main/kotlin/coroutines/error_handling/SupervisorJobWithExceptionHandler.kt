package coroutines.error_handling

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

class SupervisorJobWithExceptionHandler(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        println("[ERROR] ${e.message}")
    }

    private val scope = CoroutineScope(
        SupervisorJob() + dispatcher + exceptionHandler
    )

    fun actionTopMostWithLaunch() = scope.launch {
        async {
            throw UnsupportedOperationException("Ouch!")
        }
        //when top most coroutine are launch exception handler works
    }

    fun actionTopMostWithAsync() = scope.async {
        launch {
            throw UnsupportedOperationException("Ouch!")
        }
    }

    companion object {
        fun execute() = runBlocking {
            val supervisor = SupervisorJobWithExceptionHandler()
//            supervisor.actionWithLaunch()
            supervisor.actionTopMostWithAsync()
            delay(1.seconds)
        }
    }
}


