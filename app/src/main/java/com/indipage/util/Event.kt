package com.indipage.util
import androidx.lifecycle.Observer

// 뒤로가기 할때 소비여부
class Event<T>(private val content: T) {
    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}
class EventObserver<T>(private val onEventUnhadledContent:(T)->Unit) : Observer<Event<T>>{

    override fun onChanged(event: Event<T>) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhadledContent(it)
        }
    }
}
