package com.indipage.data.datasource.remote

import com.indipage.data.api.BookMarkApiService
import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.SavedArticle
import com.indipage.data.dto.response.SavedSpace
import javax.inject.Inject

class BookMarkDataSourceImpl @Inject constructor(
    private val apiService: BookMarkApiService
) : BookMarkDataSource {

    override suspend fun getSavedArticles(): BaseResponse<List<SavedArticle>> {
        return apiService.getSavedArticles()
    }

    override suspend fun getSavedSpaces(): BaseResponse<List<SavedSpace>> {
        return apiService.getSavedSpaces()
    }
}