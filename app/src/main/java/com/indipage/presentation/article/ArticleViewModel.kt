package com.indipage.presentation.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import com.indipage.domain.repository.ArticleRepository
import com.indipage.util.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _putArticleSlide = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val putArticleSlide: StateFlow<UiState<Int>> = _putArticleSlide.asStateFlow()

    private val _openArticleDetail = MutableLiveData<Event<ResponseArticleWeeklyDto>>()
    val openArticleDetail: LiveData<Event<ResponseArticleWeeklyDto>> = _openArticleDetail

    private val _openArticleAll = MutableLiveData<Event<ResponseArticleWeeklyDto>>()
    val openArticleAll: LiveData<Event<ResponseArticleWeeklyDto>> = _openArticleAll


    init {

    }

    fun openArticleAll(responseArticleWeeklyDto: ResponseArticleWeeklyDto?) {
        if (responseArticleWeeklyDto !=null) _openArticleAll.value = Event(responseArticleWeeklyDto)
    }

    fun openArticleDetail(responseArticleWeeklyDto: ResponseArticleWeeklyDto) {
        _openArticleDetail.value = Event(responseArticleWeeklyDto)
    }

    fun getArticleWeekly() = viewModelScope.launch {
        apiRepository.getArticleWeekly().onSuccess {
            _articleWeeklyData.value = it
            Timber.d("Success")
        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun getArticleSlide() = viewModelScope.launch {
        apiRepository.getArticleSlide().onSuccess {
            _articleSlideData.value = it
            Timber.d("Success")
        }.onFailure {
            Timber.d(it.message.toString())
        }
    }

    fun putArticleSlide() = viewModelScope.launch {
        apiRepository.putArticleSlide().onSuccess {
            _putArticleSlide.value = UiState.Success(it)
            Timber.d("Success")
        }.onFailure {
            _putArticleSlide.value = UiState.Success(400)
            Timber.d(it.message.toString())
        }
    }

}
