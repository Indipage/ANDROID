package com.indipage.presentation.search

import androidx.lifecycle.ViewModel
import com.indipage.data.dto.response.ResponseSearchData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() :
    ViewModel() {
    private val _searchKeyWord = MutableStateFlow("")
    val searchList = mutableListOf(
        ResponseSearchData.SearchDetailData(
            id = 1,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안녁아세ㅗㅗ요",
            address = "동작구 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 2,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안녁ㅎ아세요",
            address = "성동구 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 3,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안녁아호세요",
            address = "광진구 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 4,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안ㅁㄴ녁아세요",
            address = "용산구 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 5,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안녁아ㅍ세요",
            address = "서초구 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 6,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안ㅇ녁아세요",
            address = "노진구 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 6,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안ㅇ녁아세요",
            address = "진진자라 입니맨"
        ),
        ResponseSearchData.SearchDetailData(
            id = 6,
            imageUrl = "https://avatars.githubusercontent.com/u/76741702?v=4",
            name = "안ㅇ녁아세요",
            address = "곽의진 입니맨"
        ),
    )
}