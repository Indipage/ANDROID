package com.indipage.ui.ticket.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.usecase.CardUseCase
import com.indipage.domain.usecase.TicketUseCase
import com.indipage.mapper.toCardModelEntity
import com.indipage.model.CardModel
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
    private val cardUseCase: CardUseCase
) : ViewModel() {


    private val _card = MutableStateFlow<UiState<List<CardModel>>>(UiState.Loading)
    val card: StateFlow<UiState<List<CardModel>>> = _card.asStateFlow()

    private val _cardEvent = MutableLiveData<Event<String>>()
    val cardEvent: LiveData<Event<String>> = _cardEvent

    init {
        getCardList()
    }

    fun getCardList() = viewModelScope.launch {
        cardUseCase().collect { it ->
            val cardList = it?.toCardModelEntity()
            if (cardList != null) _card.value = UiState.Success(cardList)
            else _card.value = UiState.Empty
            Timber.d("Success ${it}")
        }
    }


    fun setMainCard(cardUrl: String) {
        _cardEvent.value = Event(cardUrl)
    }

}