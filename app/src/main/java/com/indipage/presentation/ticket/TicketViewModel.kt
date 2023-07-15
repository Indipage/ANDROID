package com.indipage.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.repository.TicketRepository
import com.indipage.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TicketViewModel @Inject constructor(
    private val apiRepository: TicketRepository
) : ViewModel() {

    private val _openProductEvent = MutableLiveData<Event<String>>()
    val openProductEvent: LiveData<Event<String>> = _openProductEvent

    private val _qrResponseCode = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val qrResponseCode: StateFlow<UiState<Int>> = _qrResponseCode.asStateFlow()

    init {
        getTicketList()
    }
    fun openQR() {
        _openProductEvent.value = Event("test")
    }

    fun isCheckQR(spaceId:Int) = viewModelScope.launch {
        apiRepository.isCheckQR(spaceId)
            .onSuccess { it ->
                _qrResponseCode.value=UiState.Success(it)
                Timber.d("Success ${it}")
            }
            .onFailure {
                _qrResponseCode.value=UiState.Success(404)
                Timber.d("Fail ${it}")
            }
    }

    fun closeQR() {
        _qrResponseCode.value=UiState.Success(100)
    }

    fun getTicketList() = viewModelScope.launch {
        apiRepository.getTicketList()
            .onSuccess { it ->
                Timber.d("Success ${it}")
            }
            .onFailure {
            }
    }

}