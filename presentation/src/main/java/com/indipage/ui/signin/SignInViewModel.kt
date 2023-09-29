package com.indipage.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.collectOutcome
import com.indipage.domain.model.Token
import com.indipage.domain.repository.AuthRepository
import com.indipage.domain.usecase.TokenUseCase
import com.indipage.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val tokenUseCase: TokenUseCase,
    private val authRepository: AuthRepository,
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _jwtToken = MutableStateFlow<UiState<Token>>(UiState.Loading)
    val jwtToken: StateFlow<UiState<Token>> = _jwtToken.asStateFlow()

    fun postGoogleLogin(token: String) = viewModelScope.launch {
        Timber.tag("test").d("실행됨")
        tokenUseCase(token).collect {
            _jwtToken.value = UiState.Success(it)
            Timber.d(authRepository.getAccessToken())
        }
        _jwtToken.value = UiState.Loading
    }

    fun getUser() = viewModelScope.launch {
        userUseCase().collectOutcome(
            handleSuccess = {
                Timber.d("Success")
            },
            handleFail = {
                Timber.d("Fail")
                postLogout()
            }
        )
    }

    private val _logoutState = MutableStateFlow<SignCheck<Boolean>>(SignCheck.Empty)
    val logoutState: StateFlow<SignCheck<Boolean>> = _logoutState.asStateFlow()
    fun postLogout() {
        _logoutState.value = SignCheck.Success(true)
        saveToken("")
    }

    fun getToken() = authRepository.getAccessToken()
    fun saveToken(token: String) = authRepository.saveAccessToken(token)

}