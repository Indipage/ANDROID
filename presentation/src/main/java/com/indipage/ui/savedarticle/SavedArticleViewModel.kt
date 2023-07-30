package com.indipage.ui.savedarticle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.model.Article
import com.indipage.domain.usecase.BookMarkUseCase
import com.indipage.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SavedArticleViewModel @Inject constructor(
    private val useCase: BookMarkUseCase
) : ViewModel() {

    private val _savedArticles = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val savedArticles: StateFlow<UiState<List<Article>>> = _savedArticles.asStateFlow()

    init {

    }

    private val _openArticleEvent = MutableLiveData<Event<Long>>()
    val openArticleEvent: LiveData<Event<Long>> = _openArticleEvent

    fun openArticleDetail(articleId: Long) {
        _openArticleEvent.value = Event(articleId)
    }

    fun getSavedArticles() = viewModelScope.launch {
        useCase.getSavedArticles()
            .onSuccess { savedArticles ->
                if (savedArticles != null) _savedArticles.value = UiState.Success(savedArticles)
                else _savedArticles.value = UiState.Empty
                Timber.d("Success $savedArticles")
            }
            .onFailure {
                Timber.d("Fail $it")
            }
    }

}