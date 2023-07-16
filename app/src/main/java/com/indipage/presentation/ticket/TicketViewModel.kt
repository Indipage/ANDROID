package com.indipage.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseTicketDto
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

    private val _openQrEvent = MutableLiveData<Event<String>>()
    val openQrEvent: LiveData<Event<String>> = _openQrEvent

    private val _qrResponseCode = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val qrResponseCode: StateFlow<UiState<Int>> = _qrResponseCode.asStateFlow()

    private val _ticket = MutableStateFlow<UiState<List<ResponseTicketDto>>>(UiState.Loading)
    val ticket: StateFlow<UiState<List<ResponseTicketDto>>> = _ticket.asStateFlow()

    init {
        getTicketList()
    }

    fun getTicketList() = viewModelScope.launch {
        apiRepository.getTicketList()
            .onSuccess { it ->
                _ticket.value=UiState.Success(it)
                Timber.d("Success $it")
            }
            .onFailure {
                Timber.d("Fail $it")
            }
    }

    fun openQR() {
        _openQrEvent.value = Event("test")
    }

    fun isCheckQR(spaceId: Int) = viewModelScope.launch {
        apiRepository.isCheckQR(spaceId)
            .onSuccess { it ->
                _qrResponseCode.value = UiState.Success(it)
                Timber.d("Success ${it}")
            }
            .onFailure {
                _qrResponseCode.value = UiState.Success(404)
                Timber.d("Fail ${it}")
            }
    }

    fun closeQR() {
        _qrResponseCode.value = UiState.Success(100)
    }

}