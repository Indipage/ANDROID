package com.indipage.ui.articleall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indipage.domain.model.ArticleAll
import com.indipage.domain.repository.ArticleRepository
import com.indipage.domain.usecase.ArticleUseCase
import com.indipage.util.Event
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleAllViewModel @Inject constructor(
    private val useCase: ArticleUseCase
) : ViewModel() {

    private val _articleAllData: MutableLiveData<List<ArticleAll>> = MutableLiveData()
    val articleAllData: LiveData<List<ArticleAll>> = _articleAllData

    private val _openArticleDetail = MutableLiveData<Event<ArticleAll>>()
    val openArticleDetail: LiveData<Event<ArticleAll>> = _openArticleDetail

    fun getArticleAll() = viewModelScope.launch {
        useCase.getArticleAll().onSuccess {
            _articleAllData.value = it
            Timber.d("Success")
        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun openArticleDetail(articleAll: ArticleAll) {
        _openArticleDetail.value = Event(articleAll)
    }
}