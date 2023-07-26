package com.indipage.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseQrDto
import com.indipage.domain.entity.Ticket
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

    private val _openQrEvent = MutableLiveData<Event<Int>>()
    val openQrEvent: LiveData<Event<Int>> = _openQrEvent

    private val _qrResponseCode = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val qrResponseCode: StateFlow<UiState<Int>> = _qrResponseCode.asStateFlow()

    private val _qrResponse = MutableStateFlow<UiState<ResponseQrDto>>(UiState.Loading)
    val qrResponse: StateFlow<UiState<ResponseQrDto>> = _qrResponse.asStateFlow()
    private val _ticket = MutableStateFlow<UiState<List<Ticket>>>(UiState.Loading)
    val ticket: StateFlow<UiState<List<Ticket>>> = _ticket.asStateFlow()

    init {
//        getTicketList()
    }

    fun getTicketList() = viewModelScope.launch {
        apiRepository.getTicketList()
            .onSuccess { it ->
                if (it != null) _ticket.value = UiState.Success(it)
                Timber.d("Success $it")
            }
            .onFailure {
                Timber.d("Fail $it")
            }
    }

    fun openQR(spaceId: Int) {
        _openQrEvent.value = Event(spaceId)
    }

    fun isCheckQR(spaceId: Int) = viewModelScope.launch {
        apiRepository.isCheckQR(spaceId)
            .onSuccess { it ->
                if (it != null) {
                    _qrResponse.value = UiState.Success(it)
                } else {
                    _qrResponse.value = UiState.Success(ResponseQrDto("error"))
                }
                Timber.d("Success ${it}")
            }
            .onFailure {
                Timber.d("Fail ${it}")
            }
    }

    fun closeQR() {
        _qrResponse.value = UiState.Success(ResponseQrDto(""))
    }

}