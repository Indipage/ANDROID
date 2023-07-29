package com.indipage.presentation.spacedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.model.Curation
import com.indipage.domain.model.SpaceArticle
import com.indipage.domain.model.SpaceDetail
import com.indipage.domain.repository.SpaceDetailRepository
import com.indipage.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SpaceDetailViewModel @Inject constructor(private val apiRepository: SpaceDetailRepository) :
    ViewModel() {

    private val _spaceDetailData = MutableStateFlow<UiState<SpaceDetail>>(UiState.Loading)
    val spaceDetailData: StateFlow<UiState<SpaceDetail>> = _spaceDetailData.asStateFlow()

    private val _curationData = MutableStateFlow<UiState<List<Curation>>>(UiState.Loading)
    val curationData: StateFlow<UiState<List<Curation>>> = _curationData.asStateFlow()

    private val _bookMarked = MutableStateFlow<UiState<Boolean>>(UiState.Loading)
    val bookMarked: StateFlow<UiState<Boolean>> = _bookMarked.asStateFlow()

    private val _follow = MutableStateFlow<UiState<Boolean>>(UiState.Loading)
    val follow: StateFlow<UiState<Boolean>> = _follow.asStateFlow()

    private val _spaceArticle = MutableStateFlow<UiState<SpaceArticle>>(UiState.Loading)
    val spaceArticle: StateFlow<UiState<SpaceArticle>> = _spaceArticle.asStateFlow()


    private val _openArticleDetail = MutableLiveData<Event<Int>>()
    val openArticleDetail: LiveData<Event<Int>> = _openArticleDetail

    fun setSpaceId(spaceId: Int) {
        getCuration(spaceId)
        getSpaceDetail(spaceId)
        getFollow(spaceId)
        getSpaceArticle(spaceId)
        getBookmarked(spaceId)
    }

    fun getCuration(spaceId: Int) = viewModelScope.launch {
        apiRepository.getCuration(spaceId).onSuccess { Curation ->
            if (Curation != null) {
                _curationData.value = UiState.Success(Curation)
            } else {
                _curationData.value = UiState.Empty
            }
        }
            .onFailure { Timber.d("뷰모델 실패 Curation // ${it}") }
    }

    fun getSpaceDetail(spaceId: Int) = viewModelScope.launch {
        apiRepository.getSpaceDetail(spaceId).onSuccess { SpaceDetail ->
            if (SpaceDetail != null) {
                _spaceDetailData.value = UiState.Success(SpaceDetail)
                Timber.d("공간 상세 정보 실험 ${_spaceDetailData.value}")
            } else {
                _spaceDetailData.value = UiState.Empty
            }
        }
            .onFailure { Timber.d("뷰모델 실패 Space Detail // ${it}") }
    }

    fun getFollow(spaceId: Int) = viewModelScope.launch {
        apiRepository.getFollow(spaceId).onSuccess { FollowData ->
            _follow.value = UiState.Success(FollowData)
            Timber.d("뷰모델 성공 Success 조르기")
        }.onFailure { Timber.d("뷰모델 실패 Follow / ${it}") }
    }

    fun postFollow(spaceId: Int) = viewModelScope.launch {
        apiRepository.postFollow(spaceId).onSuccess {
            _follow.value = UiState.Success(true)
            Timber.d("뷰모델 성공 조르기 post Success$it")
        }.onFailure { Timber.d("뷰모델 실패 Post follow / ${it}") }
    }

    fun getSpaceArticle(spaceId: Int) = viewModelScope.launch {
        apiRepository.getSpaceArticle(spaceId).onSuccess { SpaceArticle ->
            if (SpaceArticle != null) {
                _spaceArticle.value = UiState.Success(SpaceArticle)
                Timber.d("뷰모델 성공 Space Article Success $SpaceArticle")
            } else {
                _spaceArticle.value = UiState.Empty
            }
        }.onFailure { Timber.d("뷰모델 실패 Space Article / ${it}") }
    }

    fun getBookmarked(spaceId: Int) = viewModelScope.launch {
        apiRepository.getBookmarked(spaceId).onSuccess { BookMarkData ->
            _bookMarked.value = UiState.Success(BookMarkData)
            Timber.d("뷰모델 성공 get Bookmarked ${_bookMarked.value}")
        }.onFailure { Timber.d("뷰모델 실패 get Bookmarked / ${it}") }
    }

    fun postBookMarked(spaceId: Int) = viewModelScope.launch {
        apiRepository.postBookmarked(spaceId).onSuccess {
            _bookMarked.value = UiState.Success(true)
            Timber.d("뷰모델 성공 post Bookmarked ${_bookMarked.value}")
        }.onFailure { Timber.d("뷰모델 실패 Post Bookmarked / ${it}") }
    }

    fun deleteBookMarked(spaceId: Int) = viewModelScope.launch {
        apiRepository.deleteBookmarked(spaceId).onSuccess {
            _bookMarked.value = UiState.Success(false)
            Timber.d("뷰모델 성공 delete Bookmarked ${_bookMarked.value}")
        }.onFailure { Timber.d("뷰모델 실패 delete Bookmarked // ${it}") }
    }


    fun openArticleDetailEvent(articleId: Int) {
        Timber.tag("Sak").d("test")
        _openArticleDetail.value = Event(articleId)
    }
}