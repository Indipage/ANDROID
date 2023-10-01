package com.indipage.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.collectOutcome
import com.indipage.domain.exception.NetworkErrorHandling
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

    private val _logoutState = MutableStateFlow<SignCheck<Boolean>>(SignCheck.Empty)
    val logoutState: StateFlow<SignCheck<Boolean>> = _logoutState.asStateFlow()

    fun postGoogleLogin(token: String) = viewModelScope.launch {
        tokenUseCase(token).collect {
            _jwtToken.value = UiState.Success(it)
        }
        _jwtToken.value = UiState.Loading
    }

    fun getUser() = viewModelScope.launch {
        userUseCase().collectOutcome(
            handleSuccess = {
                Timber.d("Success")
            },
            handleFail = {
                val errorHandling = when (it.error?.message) {
                    "401" -> NetworkErrorHandling.Unauthorized
                    "500" -> NetworkErrorHandling.ServerError
                    else -> NetworkErrorHandling.OtherError
                }
                when (errorHandling) {
                    is NetworkErrorHandling.Unauthorized -> postLogout()
                    is NetworkErrorHandling.ServerError -> Timber.d("서버에러")
                    is NetworkErrorHandling.OtherError -> Timber.d("다른에러")
                }
            }
        )
    }

    fun postLogout() {
        _logoutState.value = SignCheck.Success(true)
        saveToken("")
        saveCheckLogin(false)
    }

    fun getToken() = authRepository.getAccessToken()
    fun saveToken(token: String) = authRepository.saveAccessToken(token)

    fun getFirst() = authRepository.getFirst()
    fun saveFirst(firstCheck: Boolean) = authRepository.saveFirst(firstCheck)

    fun getCheckLogin(): Boolean = authRepository.checkLogin()
    fun saveCheckLogin(check: Boolean) = authRepository.saveCheckLogin(check)

}