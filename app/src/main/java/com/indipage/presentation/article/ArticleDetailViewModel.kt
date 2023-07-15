package com.indipage.presentation.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.view.UiState
import com.indipage.data.dto.response.ResponseArticleDetailDto
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

    fun getArticleDetail(articleId: Long) = viewModelScope.launch {
        apiRepository.getArticleDetail(articleId)
            .onSuccess {
                _articleDetailData.value = UiState.Success(it)
                Timber.d("Success")
            }
            .onFailure { Timber.d(it.message.toString()) }
    }
}