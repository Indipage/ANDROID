package com.indipage.presentation.article

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.request.RequestTicketReceiveDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import com.indipage.domain.repository.ArticleDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val apiRepository: ArticleDetailRepository
) : ViewModel() {

    private val _articleDetailData =
        MutableStateFlow<UiState<ResponseArticleDetailDto>>(UiState.Loading)
    val articleDetailData: StateFlow<UiState<ResponseArticleDetailDto>> =
        _articleDetailData.asStateFlow()

    private val _ticketReceiveCheckData: MutableLiveData<ResponseTicketReceiveCheckDto> =
        MutableLiveData()
    val ticketReceiveCheckData: LiveData<ResponseTicketReceiveCheckDto> = _ticketReceiveCheckData

    private val _postTicketReceive: MutableLiveData<Int> =
        MutableLiveData()
    val postTicketReceive: LiveData<Int> = _postTicketReceive

    fun getArticleDetail(articleId: Long) = viewModelScope.launch {
        apiRepository.getArticleDetail(articleId)
            .onSuccess {
                _articleDetailData.value = UiState.Success(it)
                Timber.d("Success")
            }
            .onFailure { Timber.d(it.message.toString()) }
    }

    fun getTicketReceiveCheck(spaceId: Long) = viewModelScope.launch {
        apiRepository.getTicketReceiveCheck(spaceId)
            .onSuccess {
                _ticketReceiveCheckData.value = it
                Timber.d("Success")
            }
            .onFailure { Timber.d(it.message.toString()) }
    }

    fun postTicketReceive(spaceId: Long, requestDto: RequestTicketReceiveDto) =
        viewModelScope.launch {
            apiRepository.postTicketReceive(spaceId)
                .onSuccess {
                    _postTicketReceive.value = it
                    Timber.d("Success")
                    Log.d("ddd", "ddd")
                }
                .onFailure {
                    Timber.d(it.message.toString())
                }
        }
}