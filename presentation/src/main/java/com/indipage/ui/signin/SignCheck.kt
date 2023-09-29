package com.indipage.ui.signin

import com.example.core_ui.view.UiState


sealed interface SignCheck<out T> {
    object Empty : SignCheck<Nothing>
    data class Success<T>(
        val data: T,
    ) : SignCheck<T>



    fun getUiStateModel(): SignCheckModel {
        return SignCheckModel(
            this is Empty,
            this is Success,
        )
    }
}

data class SignCheckModel(
    val isSuccess: Boolean = false,
    val isEmpty: Boolean = false,
)