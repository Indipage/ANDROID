package com.indipage.ui.ticket.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.model.MainCard
import com.indipage.domain.repository.TicketRepository
import com.indipage.domain.usecase.TicketUseCase
import com.indipage.mapper.toTicketModelEntity
import com.indipage.model.TicketModel
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
    private val apiRepository: TicketRepository,
    private val ticketUseCase: TicketUseCase,
) : ViewModel() {

    private val _openQrEvent = MutableLiveData<Event<Int>>()
    val openQrEvent: LiveData<Event<Int>> = _openQrEvent

    private val _qrResponseCode = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val qrResponseCode: StateFlow<UiState<Int>> = _qrResponseCode.asStateFlow()

    private val _qrResponse = MutableStateFlow<UiState<MainCard>>(UiState.Loading)
    val qrResponse: StateFlow<UiState<MainCard>> = _qrResponse.asStateFlow()
    private val _ticket = MutableStateFlow<UiState<List<TicketModel>>>(UiState.Loading)
    val ticket: StateFlow<UiState<List<TicketModel>>> = _ticket.asStateFlow()

    init {
//        getTicketList()
    }

    fun getTicketList() = viewModelScope.launch {
        ticketUseCase().collect{ it ->
                val ticketList = it?.toTicketModelEntity()
                if (ticketList != null) {
                    _ticket.value = UiState.Success(ticketList)
                    Timber.d("Success $it")
                } else _ticket.value = UiState.Empty
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
                    _qrResponse.value = UiState.Success(MainCard("error"))
                }
                Timber.d("Success ${it}")
            }
            .onFailure {
                Timber.d("Fail ${it}")
            }
    }

    fun closeQR() {
        _qrResponse.value = UiState.Success(MainCard(""))
    }

}