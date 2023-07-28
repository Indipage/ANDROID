package com.indipage.data.datasource.remote

import com.indipage.data.api.ArticleApiService
import com.indipage.data.datasource.ArticleDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleSlideDto
import com.indipage.data.dto.response.ResponseArticleWeeklyDto
import javax.inject.Inject

class ArticleDataSourceImpl @Inject constructor(
    private val apiService: ArticleApiService
) : ArticleDataSource {
    override suspend fun getArticleWeekly(): BaseResponseNullable<ResponseArticleWeeklyDto> {
        return apiService.getArticleWeekly()
    }

    override suspend fun getArticleSlide(): BaseResponseNullable<ResponseArticleSlideDto> {
        return apiService.getArticleSlide()
    }

    override suspend fun putArticleSlide(): NullResponse {
        return apiService.putArticleSlide()
    }

    override suspend fun getArticleAll(): BaseResponseNullable<List<ResponseArticleAllDto>> {
        return apiService.getArticleAll()
    }

}