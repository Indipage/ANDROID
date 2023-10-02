package com.indipage.data.api

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.ResponseArticleBookmarkDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseTicketReceiveCheckDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleDetailApiService {

    companion object{
        const val ARTICLE = "article"
        const val SPACE_ID = "spaceId"
        const val ARTICLE_ID = "articleId"
        const val USER = "user"
        const val BOOKMARK = "bookmark"
        const val TICKET = "ticket"
    }

    @GET("/$ARTICLE/{$ARTICLE_ID}")
    suspend fun getArticleDetail(
        @Path(value = "$ARTICLE_ID") articleId: Long
    ): BaseResponseNullable<ResponseArticleDetailDto>

    @GET("/$USER/$TICKET/{$SPACE_ID}")
    suspend fun getTicketReceiveCheck(
        @Path(value = "$SPACE_ID") spaceId: Long
    ): BaseResponseNullable<ResponseTicketReceiveCheckDto>

    @POST("/$USER/$TICKET/{$SPACE_ID}")
    suspend fun postTicketReceive(
        @Path(value = "$SPACE_ID") spaceId: Long
    ): NullResponse

    @GET("/$BOOKMARK/$ARTICLE/{$ARTICLE_ID}")
    suspend fun getBookmark(
        @Path(value = "$ARTICLE_ID") articleId: Long
    ): BaseResponseNullable<ResponseArticleBookmarkDto>

    @POST("/$BOOKMARK/$ARTICLE/{$ARTICLE_ID}")
    suspend fun postBookmark(
        @Path(value = "$ARTICLE_ID") articleId: Long
    ): NullResponse

    @DELETE("/$BOOKMARK/$ARTICLE/{$ARTICLE_ID}")
    suspend fun deleteBookmark(
        @Path(value = "$ARTICLE_ID") articleId: Long
    ): NullResponse

}