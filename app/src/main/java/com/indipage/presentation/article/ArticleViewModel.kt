package com.indipage.presentation.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.domain.repository.ArticleRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleViewModel @Inject constructor(
    private val apiRepository: ArticleRepository
) : ViewModel() {

    private val _articleWeeklyData: MutableLiveData<ResponseArticleWeeklyDto> = MutableLiveData()
    val articleWeeklyData: LiveData<ResponseArticleWeeklyDto> = _articleWeeklyData

    private val _articleSlideData: MutableLiveData<ResponseArticleSlideDto> = MutableLiveData()
    val articleSlideData: LiveData<ResponseArticleSlideDto> = _articleSlideData

    init {
        getArticleWeekly()
        getArticleSlide()
    }

    private fun getArticleWeekly() = viewModelScope.launch {
        apiRepository.getArticleWeekly().onSuccess {
            _articleWeeklyData.value = it
            Timber.d("Success")
        }.onFailure { Timber.d(it.message.toString()) }
    }

    private fun getArticleSlide() = viewModelScope.launch {
        apiRepository.getArticleSlide().onSuccess {
            _articleSlideData.value = it
            Timber.d("Success")
        }.onFailure {
            Timber.d(it.message.toString())
        }
    }

}