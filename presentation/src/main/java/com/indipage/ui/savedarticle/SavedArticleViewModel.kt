package com.indipage.ui.savedarticle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.collectOutcome
import com.indipage.domain.usecase.BookMarkArticleUseCase
import com.indipage.mapper.toArticleModelEntity
import com.indipage.model.ArticleModel
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
    private val bookMarkArticleUseCase: BookMarkArticleUseCase
) : ViewModel() {

    private val _savedArticles = MutableStateFlow<UiState<List<ArticleModel>>>(UiState.Loading)
    val savedArticles: StateFlow<UiState<List<ArticleModel>>> = _savedArticles.asStateFlow()

    private val _openArticleEvent = MutableLiveData<Event<Long>>()
    val openArticleEvent: LiveData<Event<Long>> = _openArticleEvent

    fun openArticleDetail(articleId: Long) {
        _openArticleEvent.value = Event(articleId)
    }

    fun getSavedArticles() = viewModelScope.launch {
        bookMarkArticleUseCase().collectOutcome(
            handleSuccess = { savedArticles ->
                val savedArticle = savedArticles.data?.toArticleModelEntity()
                if (savedArticle != null) _savedArticles.value = UiState.Success(savedArticle)
                else _savedArticles.value = UiState.Empty
                Timber.d("Article Success")
            },
            handleFail = {
                Timber.d("Fail")
            }
        )

    }

}