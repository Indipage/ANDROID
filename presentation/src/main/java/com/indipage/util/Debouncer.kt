    package com.indipage.util

    import kotlinx.coroutines.*

    class Debouncer<T> {
        private var debounceJob: Job? = null
        fun setDelay(value: T, delay: Long, action: (T) -> Unit) {
            debounceJob?.cancel()
            debounceJob = GlobalScope.launch(Dispatchers.Main) {
                delay(delay)
                action(value)
            }
        }
    }