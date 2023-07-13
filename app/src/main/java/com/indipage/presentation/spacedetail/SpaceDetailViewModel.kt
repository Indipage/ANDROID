package com.indipage.presentation.spacedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.CurationData
import com.indipage.domain.repository.SpaceDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SpaceDetailViewModel @Inject constructor(private val apiRepository: SpaceDetailRepository) :
    ViewModel() {

    private val _curationData = MutableStateFlow<UiState<List<CurationData>>>(UiState.Loading)
    val curationData: StateFlow<UiState<List<CurationData>>> = _curationData.asStateFlow()

    init {
        getCuration()
    }

    fun getCuration() = viewModelScope.launch {
        apiRepository.getCuration().onSuccess { CurationData ->
            _curationData.value = UiState.Success(CurationData)
            Timber.d("Success")
        }
            .onFailure { Timber.d("Fail Cause ${it}") }
    }
}