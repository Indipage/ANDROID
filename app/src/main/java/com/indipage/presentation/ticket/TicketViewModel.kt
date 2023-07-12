package com.indipage.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.indipage.util.Event
import javax.inject.Inject

class TicketViewModel @Inject constructor(
) : ViewModel() {

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    fun openQR() {
        _openProductEvent.value = Event("test")
    }

}