package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.SavedArticle
import com.indipage.data.dto.response.SavedSpace

interface BookMarkDataSource {
    suspend fun getSavedArticles(): BaseResponse<List<SavedArticle>>
    suspend fun getSavedSpaces(): BaseResponse<List<SavedSpace>>
}