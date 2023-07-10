package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.SavedArticle

interface BookMarkDataSource {
    suspend fun getSavedArticles(): BaseResponse<List<SavedArticle>>
}