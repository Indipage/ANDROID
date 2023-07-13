package com.indipage.presentation.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.domain.repository.ArticleDetailRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val apiRepository: ArticleDetailRepository
) : ViewModel() {

    private val _setAdapter = MutableLiveData<ResponseArticleDetailDto>()
    val setAdapter: LiveData<ResponseArticleDetailDto> = _setAdapter

    fun getArticleDetail(articleId: Long) = viewModelScope.launch {
        apiRepository.getArticleDetail(articleId)
            .onSuccess {
                _setAdapter.value = it
                Timber.d("Success")
            }
            .onFailure { Timber.d(it.message.toString()) }
    }
}