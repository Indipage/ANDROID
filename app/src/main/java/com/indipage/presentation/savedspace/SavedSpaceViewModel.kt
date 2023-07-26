package com.indipage.presentation.savedspace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseSpaceDto
import com.indipage.domain.entity.Space
import com.indipage.domain.repository.BookMarkRepository
import com.indipage.domain.usecase.BookMarkUseCase
import com.indipage.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SavedSpaceViewModel @Inject constructor(
    private val useCase: BookMarkUseCase
) : ViewModel() {

    private val _savedSpaces = MutableStateFlow<UiState<List<Space>>>(UiState.Loading)
    val savedSpaces: StateFlow<UiState<List<Space>>> = _savedSpaces.asStateFlow()

    private val _openSpaceEvent = MutableLiveData<Event<Int>>()
    val openSpaceEvent: LiveData<Event<Int>> = _openSpaceEvent

    fun openSpaceDetail(productPostId: Int) {
        _openSpaceEvent.value = Event(productPostId)
    }

    fun getSavedSpaces() = viewModelScope.launch {
        useCase.getSavedSpaces()
            .onSuccess { savedSpaces ->
                if (savedSpaces != null) {
                    _savedSpaces.value = UiState.Success(savedSpaces)
                    Timber.d("Success")
                } else _savedSpaces.value = UiState.Empty
            }
            .onFailure {
                Timber.d("Fail$it")
            }
    }

}