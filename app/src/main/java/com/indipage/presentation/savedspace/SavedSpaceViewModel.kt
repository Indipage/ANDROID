package com.indipage.presentation.savedspace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.SavedSpace
import com.indipage.domain.repository.BookMarkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SavedSpaceViewModel @Inject constructor(
    private val apiRepository: BookMarkRepository
) : ViewModel() {

    private val _savedSpaces = MutableStateFlow<UiState<List<SavedSpace>>>(UiState.Loading)
    val savedSpaces: StateFlow<UiState<List<SavedSpace>>> = _savedSpaces.asStateFlow()

    init {
        getSavedSpaces()
    }

    fun getSavedSpaces() = viewModelScope.launch {
        apiRepository.getSavedSpaces()
            .onSuccess { savedSpaces ->
                _savedSpaces.value = UiState.Success(savedSpaces)
                Timber.d("Success")
            }
            .onFailure {
                Timber.d("Fail")
            }
    }

}