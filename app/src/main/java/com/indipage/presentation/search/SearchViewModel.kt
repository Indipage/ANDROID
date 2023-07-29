package com.indipage.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.domain.entity.Search
import com.indipage.domain.repository.SearchRepository
import com.indipage.util.Event
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
    private val _searchData = MutableStateFlow<UiState<List<Search>>>(UiState.Loading)
    val searchData: StateFlow<UiState<List<Search>>> = _searchData.asStateFlow()

    private val _openSpaceEvent = MutableLiveData<Event<Long>>()
    val openSpaceEvent: LiveData<Event<Long>> = _openSpaceEvent

    init {
        getSearchResult(null)
    }

    fun openSpaceDetail(spaceId: Long) {
        _openSpaceEvent.value = Event(spaceId)
    }

    fun getSearchResult(keyword: String?) = viewModelScope.launch {
        apiRepository.getSearchResult(keyword)
            .onSuccess { Search ->
                if (Search != null) {
                    _searchData.value = UiState.Success(Search)
                    Timber.d("검색 서버 통신 Success 성공! ${_searchData.value}")
                } else {
                    _searchData.value = UiState.Empty
                }
            }
            .onFailure {
                Timber.tag("검색").d("Fail $it")
            }
    }
}