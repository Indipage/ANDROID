package com.indipage.presentation.ticket.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.model.Card
import com.indipage.domain.usecase.TicketUseCase
import com.indipage.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val useCase: TicketUseCase
) : ViewModel() {


    private val _card = MutableStateFlow<UiState<List<Card>>>(UiState.Loading)
    val card: StateFlow<UiState<List<Card>>> = _card.asStateFlow()

    private val _cardEvent = MutableLiveData<Event<String>>()
    val cardEvent: LiveData<Event<String>> = _cardEvent
    init {
        getCardList()
    }

    fun getCardList() = viewModelScope.launch {
        useCase.getCardList()
            .onSuccess { it ->
                if (it != null) _card.value = UiState.Success(it)
                else _card.value = UiState.Empty
                Timber.d("Success ${it}")
            }
            .onFailure {
                Timber.d("Fail ${it}")
            }
    }


    fun setMainCard(cardUrl:String) {
        _cardEvent.value = Event(cardUrl)
    }

}