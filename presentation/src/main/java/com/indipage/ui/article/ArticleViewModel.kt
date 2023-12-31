package com.indipage.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.model.ArticleSlide
import com.indipage.domain.model.ArticleWeekly
import com.indipage.domain.usecase.ArticleUseCase
import com.indipage.util.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleViewModel @Inject constructor(
    private val useCase: ArticleUseCase
) : ViewModel() {

    private val _articleWeeklyData: MutableLiveData<ArticleWeekly> = MutableLiveData()
    val articleWeeklyData: LiveData<ArticleWeekly> = _articleWeeklyData

    private val _articleSlideData: MutableLiveData<ArticleSlide> = MutableLiveData()
    val articleSlideData: LiveData<ArticleSlide> = _articleSlideData

    private val _putArticleSlide = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val putArticleSlide: StateFlow<UiState<Int>> = _putArticleSlide.asStateFlow()

    private val _openArticleDetail = MutableLiveData<Event<ArticleWeekly>>()
    val openArticleDetail: LiveData<Event<ArticleWeekly>> = _openArticleDetail

    fun openArticleDetail(articleWeekly: ArticleWeekly) {
        _openArticleDetail.value = Event(articleWeekly)
    }

    fun getArticleWeekly() = viewModelScope.launch {
        useCase.getArticleWeekly().onSuccess {
            if (it != null) {
                _articleWeeklyData.value = it
                Timber.d("Success")
            }
        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun getArticleSlide() = viewModelScope.launch {
        useCase.getArticleSlide().onSuccess {
            if (it != null) {
                _articleSlideData.value = it
                Timber.d("Success")
            }
        }.onFailure {
            Timber.d(it.message.toString())
        }
    }

    fun putArticleSlide() = viewModelScope.launch {
        useCase.putArticleSlide().onSuccess {
            _putArticleSlide.value = UiState.Success(it)
            Timber.d("Success")
        }.onFailure {
            _putArticleSlide.value = UiState.Success(400)
            Timber.d(it.message.toString())
        }
    }

}
