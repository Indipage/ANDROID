package com.indipage.presentation.savedarticle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.domain.repository.BookMarkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SavedArticleViewModel @Inject constructor(
    private val apiRepository: BookMarkRepository
) : ViewModel() {

    private val _savedArticles = MutableStateFlow<UiState<List<ResponseArticleDto>>>(UiState.Loading)
    val savedArticles: StateFlow<UiState<List<ResponseArticleDto>>> = _savedArticles.asStateFlow()

    init {
        getSavedArticles()
    }

    fun getSavedArticles() = viewModelScope.launch {
        apiRepository.getSavedArticles()
            .onSuccess { savedArticles ->
                _savedArticles.value = UiState.Success(savedArticles)
                Timber.d("Success $savedArticles")
            }
            .onFailure {
                Timber.d("Fail $it")
            }
    }

}