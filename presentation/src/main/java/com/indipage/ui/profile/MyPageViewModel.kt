package com.indipage.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.usecase.UserUseCase
import com.indipage.model.UserInfoModel
import com.indipage.model.toUserModelEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val useCase: UserUseCase
) : ViewModel() {

    private val _userInfo = MutableStateFlow<UiState<UserInfoModel>>(UiState.Loading)
    val userInfo: StateFlow<UiState<UserInfoModel>> = _userInfo.asStateFlow()

    init {
        getSavedSpaces()
    }

    fun getSavedSpaces() = viewModelScope.launch {
        useCase.getUserInfo().collect{ savedSpaces ->
                _userInfo.value = UiState.Success(savedSpaces.toUserModelEntity())
                Timber.d("Success")
            }

    }

}