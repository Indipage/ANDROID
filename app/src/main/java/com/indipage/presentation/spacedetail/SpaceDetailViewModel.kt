package com.indipage.presentation.spacedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData
import com.indipage.domain.repository.SpaceDetailRepository
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

    private val _spaceDetailData = MutableStateFlow<UiState<SpaceDetailData>>(UiState.Loading)
    val spaceDetailData: StateFlow<UiState<SpaceDetailData>> = _spaceDetailData.asStateFlow()

    private val _curationData = MutableStateFlow<UiState<List<CurationData>>>(UiState.Loading)
    val curationData: StateFlow<UiState<List<CurationData>>> = _curationData.asStateFlow()

    private val _bookMarked = MutableStateFlow<UiState<BookmarkData>>(UiState.Loading)
    val bookMarked: StateFlow<UiState<BookmarkData>> = _bookMarked.asStateFlow()

    private val _follow = MutableStateFlow<UiState<FollowData>>(UiState.Loading)
    val follow: StateFlow<UiState<FollowData>> = _follow.asStateFlow()

    private val _spaceArticle = MutableStateFlow<UiState<SpaceArticleData?>>(UiState.Loading)
    val spaceArticle: StateFlow<UiState<SpaceArticleData?>> = _spaceArticle.asStateFlow()

    fun setSpaceId(spaceId: Int) {
        getCuration(spaceId)
        getSpaceDetail(spaceId)
        getFollow(spaceId)
        getSpaceArticle(spaceId)
        getBookmarked(spaceId)
    }

    fun getCuration(spaceId: Int) = viewModelScope.launch {
        apiRepository.getCuration(spaceId).onSuccess { CurationData ->
            _curationData.value = UiState.Success(CurationData)
        }
            .onFailure { Timber.d("뷰모델 실패 Curation // ${it}") }
    }

    fun getSpaceDetail(spaceId: Int) = viewModelScope.launch {
        apiRepository.getSpaceDetail(spaceId).onSuccess { SpaceDetailData ->
            _spaceDetailData.value = UiState.Success(SpaceDetailData)
            Timber.d("공간 상세 정보 실험 ${_spaceDetailData.value}")
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
            _follow.value = UiState.Success(FollowData(true))
            Timber.d("뷰모델 성공 조르기 post Success$it")
        }.onFailure { Timber.d("뷰모델 실패 Post follow / ${it}") }
    }

    fun getSpaceArticle(spaceId: Int) = viewModelScope.launch {
        apiRepository.getSpaceArticle(spaceId).onSuccess { SpaceArticleData ->
            _spaceArticle.value = UiState.Success(SpaceArticleData)
            Timber.d("뷰모델 성공 Space Article Success $SpaceArticleData")
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
            _bookMarked.value = UiState.Success(BookmarkData(true))
            Timber.d("뷰모델 성공 post Bookmarked ${_bookMarked.value}")
        }.onFailure { Timber.d("뷰모델 실패 Post Bookmarked / ${it}") }
    }

    fun deleteBookMarked(spaceId: Int) = viewModelScope.launch {
        apiRepository.deleteBookmarked(spaceId).onSuccess {
            _bookMarked.value = UiState.Success(BookmarkData(false))
            Timber.d("뷰모델 성공 delete Bookmarked ${_bookMarked.value}")
        }.onFailure { Timber.d("뷰모델 실패 delete Bookmarked // ${it}") }
    }
}