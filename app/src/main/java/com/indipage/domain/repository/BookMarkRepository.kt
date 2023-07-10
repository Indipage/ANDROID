package com.indipage.domain.repository

import androidx.paging.PagingData
import com.indipage.data.dto.response.SavedArticle
import kotlinx.coroutines.flow.Flow

interface BookMarkRepository {
    fun getSavedArticles(): Flow<PagingData<SavedArticle>>
}