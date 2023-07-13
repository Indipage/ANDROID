package com.indipage.presentation.spacedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData
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

    private val _spaceDetailData = MutableStateFlow<UiState<SpaceDetailData>>(UiState.Loading)
    val spaceDetailData: StateFlow<UiState<SpaceDetailData>> = _spaceDetailData.asStateFlow()
    private val _curationData = MutableStateFlow<UiState<List<CurationData>>>(UiState.Loading)
    val curationData: StateFlow<UiState<List<CurationData>>> = _curationData.asStateFlow()

    init {
        getCuration()
        getSpaceDetail()
    }

    fun getCuration() = viewModelScope.launch {
        apiRepository.getCuration().onSuccess { CurationData ->
            _curationData.value = UiState.Success(CurationData)
        }
            .onFailure { Timber.d("Curation Fail Cause ${it}") }
    }

    fun getSpaceDetail() = viewModelScope.launch {
        apiRepository.getSpaceDetail().onSuccess { SpaceDetailData ->
            _spaceDetailData.value = UiState.Success(SpaceDetailData)
            Timber.d("실험 Success")
        }
            .onFailure { Timber.d("Space Detail Fail Cause ${it}") }
    }
}