package com.indipage.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseSearchData
import com.indipage.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val apiRepository: SearchRepository) :
    ViewModel() {

    private val _keyword = MutableLiveData<String>()
    val keyword: LiveData<String> = _keyword

    private val _searchData = MutableStateFlow<UiState<List<ResponseSearchData>>>(UiState.Loading)
    val searchData: StateFlow<UiState<List<ResponseSearchData>>> = _searchData.asStateFlow()

    val searchList = mutableListOf(
        ResponseSearchData(
            spaceId = 1,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안녁아세ㅗㅗ요",
            address = "동작구 입니맨"
        ),
        ResponseSearchData(
            spaceId = 2,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안녁ㅎ아세요",
            address = "성동구 입니맨"
        ),
        ResponseSearchData(
            spaceId = 3,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안녁아호세요",
            address = "광진구 입니맨"
        ),
        ResponseSearchData(
            spaceId = 4,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안ㅁㄴ녁아세요",
            address = "용산구 입니맨"
        ),
        ResponseSearchData(
            spaceId = 5,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안녁아ㅍ세요",
            address = "서초구 입니맨"
        ),
        ResponseSearchData(
            spaceId = 6,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안ㅇ녁아세요",
            address = "노진구 입니맨"
        ),
        ResponseSearchData(
            spaceId = 6,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안ㅇ녁아세요",
            address = "진진자라 입니맨"
        ),
        ResponseSearchData(
            spaceId = 6,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            spaceName = "안ㅇ녁아세요",
            address = "곽의진 입니맨"
        ),
    )

    fun getSearchResult() = viewModelScope.launch {
        apiRepository.getSearchResult(keyword.value)
            .onSuccess { searchData ->
                _searchData.value = UiState.Success(searchData)
                Timber.d("서치뷰 Success 성공! ${_searchData.value}")
            }
            .onFailure {
                Timber.tag("서치뷰").d("Fail $it")
            }
    }
}