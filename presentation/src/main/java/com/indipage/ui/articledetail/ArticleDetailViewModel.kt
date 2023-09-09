package com.indipage.ui.articledetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.model.ArticleBookmark
import com.indipage.domain.model.ArticleDetail
import com.indipage.domain.model.TicketReceiveCheck
import com.indipage.domain.usecase.ArticleDetailUseCase
import com.indipage.util.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val useCase: ArticleDetailUseCase
) : ViewModel() {

    private val _articleDetailData = MutableStateFlow<UiState<ArticleDetail>>(UiState.Loading)
    val articleDetailData: StateFlow<UiState<ArticleDetail>> = _articleDetailData.asStateFlow()

    private val _articleDetailParsingData =
        MutableStateFlow<UiState<List<ArticleDetailParsing>>>(UiState.Loading)
    val articleDetailParsingData: StateFlow<UiState<List<ArticleDetailParsing>>> =
        _articleDetailParsingData.asStateFlow()

    private val _ticketReceiveCheckData: MutableLiveData<TicketReceiveCheck> = MutableLiveData()
    val ticketReceiveCheckData: LiveData<TicketReceiveCheck> = _ticketReceiveCheckData

    private val _postTicketReceive = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val postTicketReceive: StateFlow<UiState<Int>> = _postTicketReceive.asStateFlow()

    private val _articleBookmarkData: MutableLiveData<ArticleBookmark> = MutableLiveData()
    val articleBookmarkData: LiveData<ArticleBookmark> = _articleBookmarkData

    private val _postArticleBookmark = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val postArticleBookmark: StateFlow<UiState<Int>> = _postArticleBookmark.asStateFlow()

    private val _deleteArticleBookmark = MutableStateFlow<UiState<Int>>(UiState.Loading)
    val deleteArticleBookmark: StateFlow<UiState<Int>> = _deleteArticleBookmark.asStateFlow()

    private val _openSpaceDetail = MutableLiveData<Event<ArticleDetail>>()
    val openSpaceDetail: LiveData<Event<ArticleDetail>> = _openSpaceDetail

    private val _getArticleTicket = MutableLiveData<Int>()
    val getArticleTicket: LiveData<Int> = _getArticleTicket

    private val articleParser = ArticleParser()

    fun openSpaceDetail(articleDetail: ArticleDetail) {
        _openSpaceDetail.value = Event(articleDetail)
    }

    fun getArticleDetail(articleId: Long) = viewModelScope.launch {
        useCase.getArticleDetail(articleId).onSuccess {
            if (it != null) {
                val splitResult = articleParser.splitArticleContent(it.content, it.spaceId.toLong())
                val parsingResult = articleParser.getArticleContent(splitResult)
                _articleDetailData.value = UiState.Success(it)
                _articleDetailParsingData.value = UiState.Success(parsingResult)
                Timber.d("Success")
            } else _articleDetailData.value = UiState.Empty

        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun getTicketReceiveCheck(spaceId: Long) = viewModelScope.launch {
        useCase.getTicketReceiveCheck(spaceId).onSuccess {
            if (it != null) {
                _ticketReceiveCheckData.value = it
                Timber.d("Success")
            }
        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun postTicketReceive(spaceId: Long) = viewModelScope.launch {
        useCase.postTicketReceive(spaceId).onSuccess {
            _postTicketReceive.value = UiState.Success(it)
            _getArticleTicket.value = 200
            Timber.d("Success")
        }.onFailure {
            _postTicketReceive.value = UiState.Success(409)
            Timber.d(it.message.toString())
        }
    }

    fun getBookMark(articleId: Long) = viewModelScope.launch {
        useCase.getBookmark(articleId).onSuccess {
            if (it != null) {
                _articleBookmarkData.value = it
                Timber.d("Success")
            }
        }.onFailure { Timber.d(it.message.toString()) }
    }

    fun postBookMark(articleId: Long) = viewModelScope.launch {
        useCase.postBookmark(articleId).onSuccess {
            _postArticleBookmark.value = UiState.Success(it)
            Timber.d("Success")
        }.onFailure {
            _postArticleBookmark.value = UiState.Success(404)
            Timber.d(it.message.toString())
        }
    }

    fun deleteBookMark(articleId: Long) = viewModelScope.launch {
        useCase.deleteBookmark(articleId).onSuccess {
            _deleteArticleBookmark.value = UiState.Success(it)
            Timber.d("Success")
        }.onFailure {
            _deleteArticleBookmark.value = UiState.Success(404)
            Timber.d(it.message.toString())
        }
    }

}