package com.indipage.data.datasource.remote

import com.indipage.data.api.BookMarkApiService
import com.indipage.data.datasource.BookMarkDataSource
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseArticleDto
import com.indipage.data.dto.response.ResponseSpaceDto
import javax.inject.Inject

class BookMarkDataSourceImpl @Inject constructor(
    private val apiService: BookMarkApiService
) : BookMarkDataSource {

    override suspend fun getSavedArticles(): BaseResponseNullable<List<ResponseArticleDto>> {
        return apiService.getSavedArticles()
    }

    override suspend fun getSavedSpaces(): BaseResponseNullable<List<ResponseSpaceDto>> {
        return apiService.getSavedSpaces()
    }
}