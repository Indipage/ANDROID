package com.indipage.data.datasource.remote

import com.indipage.data.api.ArticleDetailApiService
import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import javax.inject.Inject

class ArticleDetailDataSourceImpl
@Inject constructor(
    private val apiService: ArticleDetailApiService
) : ArticleDetailDataSource {
    override suspend fun getArticleDetail(articleId: Long): BaseResponse<ResponseArticleDetailDto> {
        return apiService.getArticleDetail(articleId)
    }

    override suspend fun getTicketReceiveCheck(spaceId: Long): BaseResponse<ResponseTicketReceiveCheckDto> {
        return apiService.getTicketReceiveCheck(spaceId)
    }

    override suspend fun postTicketReceive(
        spaceId: Long
    ): QRResponse {
        return apiService.postTicketReceive(spaceId)
    }
}