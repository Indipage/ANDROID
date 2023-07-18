package com.indipage.data.datasource.remote

import com.indipage.data.api.ArticleApiService
import com.indipage.data.datasource.ArticleDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import javax.inject.Inject

class ArticleDataSourceImpl @Inject constructor(
    private val apiService: ArticleApiService
) : ArticleDataSource {
    override suspend fun getArticleWeekly(): BaseResponse<ResponseArticleWeeklyDto> {
        return apiService.getArticleWeekly()
    }

    override suspend fun getArticleSlide(): BaseResponse<ResponseArticleSlideDto> {
        return apiService.getArticleSlide()
    }

    override suspend fun putArticleSlide(): NullResponse {
        return apiService.putArticleSlide()
    }
}