package com.indipage.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.UserResponseDto
import com.indipage.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val apiRepository: UserRepository
) : ViewModel() {

    private val _userInfo = MutableStateFlow<UiState<UserResponseDto>>(UiState.Loading)
    val userInfo: StateFlow<UiState<UserResponseDto>> = _userInfo.asStateFlow()
    init {
        getSavedSpaces()
    }
    fun getSavedSpaces() = viewModelScope.launch {
        apiRepository.getUserInfo()
            .onSuccess { savedSpaces ->
                _userInfo.value = UiState.Success(savedSpaces)
                Timber.d("Success")
            }
            .onFailure {
                Timber.d("Fail")
            }
    }

}