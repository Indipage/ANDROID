package com.indipage.presentation.article

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.domain.repository.ArticleDetailRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class ArticleAllViewModel @Inject constructor(
    private val apiRepository: ArticleDetailRepository
) : ViewModel() {

    private val _articleAllData: MutableLiveData<List<ResponseArticleAllDto>> = MutableLiveData()
    val articleAllData: LiveData<List<ResponseArticleAllDto>> = _articleAllData

    init {
        getArticleAll()
    }

    fun getArticleAll() = viewModelScope.launch {
        apiRepository.getArticleAll()
            .onSuccess {
                Log.d("ddd", "sss")
                _articleAllData.value = it
                Timber.d("Success")
            }
            .onFailure { Timber.d(it.message.toString()) }
    }
}