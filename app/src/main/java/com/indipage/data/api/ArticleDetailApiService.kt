package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleAllDto
import com.indipage.data.dto.response.ResponseArticleBookmarkDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleDetailApiService {

    @GET("/article/{articleId}")
    suspend fun getArticleDetail(
        @Path(value = "articleId") articleId: Long
    ): BaseResponse<ResponseArticleDetailDto>

    @GET("/user/ticket/{spaceId}")
    suspend fun getTicketReceiveCheck(
        @Path(value = "spaceId") spaceId: Long
    ): BaseResponse<ResponseTicketReceiveCheckDto>

    @POST("/user/ticket/{spaceId}")
    suspend fun postTicketReceive(
        @Path(value = "spaceId") spaceId: Long
    ): NullResponse

    @GET("/article")
    suspend fun getArticleAll(): BaseResponse<List<ResponseArticleAllDto>>

    @GET("/bookmark/article/{articleId}")
    suspend fun getBookmark(
        @Path(value = "articleId") articleId: Long
    ): BaseResponse<ResponseArticleBookmarkDto>

    @POST("/bookmark/article/{articleId}")
    suspend fun postBookmark(
        @Path(value = "articleId") articleId: Long
    ): NullResponse

    @DELETE("/bookmark/article/{articleId}")
    suspend fun deleteBookmark(
        @Path(value = "articleId") articleId: Long
    ): NullResponse

}