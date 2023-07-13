package com.indipage.data.datasource.remote

import com.indipage.data.api.TestApiService
import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleDetailDto
import javax.inject.Inject

class ArticleDetailDataSourceImpl
@Inject constructor(
    private val apiService: TestApiService
) : ArticleDetailDataSource {
    override suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto> {
        return apiService.getArticleDetail(articleId)
    }
}