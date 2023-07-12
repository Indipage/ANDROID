package com.indipage.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.repository.TicketRepository
import com.indipage.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TicketViewModel @Inject constructor(
    private val apiRepository: TicketRepository
) : ViewModel() {

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    fun openQR() {
        _openProductEvent.value = Event("test")
    }

    fun isCheckQR(spaceId:Int) = viewModelScope.launch {
        apiRepository.isCheckQR(spaceId)
            .onSuccess { it ->
                Timber.d("Success")
            }
            .onFailure {
                Timber.d("Fail")
            }
    }

}