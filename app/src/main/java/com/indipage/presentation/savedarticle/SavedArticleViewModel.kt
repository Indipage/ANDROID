package com.indipage.presentation.savedarticle

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.indipage.data.dto.response.SavedArticle
import com.indipage.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedArticleViewModel  @Inject constructor(
    private val apiRepository: BookMarkRepository
) : ViewModel() {
    fun getRecyclerviewTest(): Flow<PagingData<SavedArticle>> =
        apiRepository.getSavedArticles()

}