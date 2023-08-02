package com.indipage.ui.savedspace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.usecase.BookMarkSpaceUseCase
import com.indipage.mapper.toSpaceModelEntity
import com.indipage.model.SpaceModel
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
    private val bookMarkSpaceUseCase: BookMarkSpaceUseCase
) : ViewModel() {

    private val _savedSpaces = MutableStateFlow<UiState<List<SpaceModel>>>(UiState.Loading)
    val savedSpaces: StateFlow<UiState<List<SpaceModel>>> = _savedSpaces.asStateFlow()

    private val _openSpaceEvent = MutableLiveData<Event<Int>>()
    val openSpaceEvent: LiveData<Event<Int>> = _openSpaceEvent

    fun openSpaceDetail(productPostId: Int) {
        _openSpaceEvent.value = Event(productPostId)
    }

    fun getSavedSpaces() = viewModelScope.launch {
        bookMarkSpaceUseCase().collect { savedSpaces ->
            val savedSpace = savedSpaces?.toSpaceModelEntity()
            if (savedSpace != null) {
                _savedSpaces.value = UiState.Success(savedSpace)
                Timber.d("Success")
            } else _savedSpaces.value = UiState.Empty
        }

    }

}