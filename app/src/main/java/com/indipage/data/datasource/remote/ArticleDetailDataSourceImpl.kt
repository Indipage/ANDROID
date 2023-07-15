package com.indipage.data.datasource.remote

import com.indipage.data.api.ArticleDetailApiService
import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketDto
import javax.inject.Inject

class ArticleDetailDataSourceImpl
@Inject constructor(
    private val apiService: ArticleDetailApiService
) : ArticleDetailDataSource {
    override suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto> {
        return apiService.getArticleDetail(articleId)
    }

    override suspend fun getTicketReceiveCheck(spaceId: Long): BaseResponse<ResponseTicketDto> {
        return apiService.getTicketReceiveCheck(spaceId)
    }
}