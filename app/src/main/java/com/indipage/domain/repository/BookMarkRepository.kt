package com.indipage.domain.repository

import com.indipage.data.dto.response.SavedArticle

interface BookMarkRepository {
    suspend fun getSavedArticles(): Result<List<SavedArticle>>

}