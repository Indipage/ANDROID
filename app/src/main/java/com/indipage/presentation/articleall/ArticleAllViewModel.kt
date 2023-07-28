package com.indipage.presentation.articleall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indipage.domain.entity.ArticleAll
import com.indipage.domain.repository.ArticleRepository
import com.indipage.util.Event
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleAllViewModel @Inject constructor(
    private val apiRepository: ArticleRepository
) : ViewModel() {

    private val _articleAllData: MutableLiveData<List<ArticleAll>> = MutableLiveData()
    val articleAllData: LiveData<List<ArticleAll>> = _articleAllData

    private val _openArticleDetail = MutableLiveData<Event<ArticleAll>>()
    val openArticleDetail: LiveData<Event<ArticleAll>> = _openArticleDetail

    fun getArticleAll() = viewModelScope.launch {
        apiRepository.getArticleAll().onSuccess {
            _articleAllData.value = it
            Timber.d("Success")
        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun openArticleDetail(articleAll: ArticleAll) {
        _openArticleDetail.value = Event(articleAll)
    }
}