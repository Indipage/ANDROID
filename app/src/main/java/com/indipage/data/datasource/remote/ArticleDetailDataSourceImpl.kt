package com.indipage.data.datasource.remote

import com.indipage.data.api.ArticleDetailApiService
import com.indipage.data.datasource.ArticleDetailDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleBookmarkDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import javax.inject.Inject

class ArticleDetailDataSourceImpl
@Inject constructor(
    private val apiService: ArticleDetailApiService
) : ArticleDetailDataSource {
    override suspend fun getArticleDetail(articleId: Long): BaseResponseNullable<ResponseArticleDetailDto> {
        return apiService.getArticleDetail(articleId)
    }

    override suspend fun getTicketReceiveCheck(spaceId: Long): BaseResponseNullable<ResponseTicketReceiveCheckDto> {
        return apiService.getTicketReceiveCheck(spaceId)
    }


    override suspend fun postTicketReceive(
        spaceId: Long
    ): NullResponse {
        return apiService.postTicketReceive(spaceId)
    }

    override suspend fun getBookmark(articleId: Long): BaseResponseNullable<ResponseArticleBookmarkDto> {
        return apiService.getBookmark(articleId)
    }

    override suspend fun postBookmark(articleId: Long): NullResponse {
        return apiService.postBookmark(articleId)
    }

    override suspend fun deleteBookmark(articleId: Long): NullResponse {
        return apiService.deleteBookmark(articleId)
    }

}