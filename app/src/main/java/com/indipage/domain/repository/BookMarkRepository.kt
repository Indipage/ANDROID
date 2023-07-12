package com.indipage.domain.repository

import com.indipage.data.dto.response.SavedArticle
import com.indipage.data.dto.response.SavedSpace

interface BookMarkRepository {
    suspend fun getSavedArticles(): Result<List<SavedArticle>>
    suspend fun getSavedSpaces(): Result<List<SavedSpace>>

}