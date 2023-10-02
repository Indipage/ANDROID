package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.NullResponse
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData
import retrofit2.http.*

interface SpaceDetailApiService {
    companion object {
        const val ARTICLE = "article"
        const val SPACE_ID = "spaceId"
        const val BOOK = "book"
        const val SPACE = "space"
        const val FOLLOW = "follow"
        const val BOOKMARK = "bookmark"
    }


    @GET("$BOOKMARK/$SPACE/{$SPACE_ID}")
    suspend fun getBookmarked(@Path("$SPACE_ID") spaceId: Int): BaseResponse<BookmarkData>

    @POST("/$BOOKMARK/${SPACE}S/{$SPACE_ID}")
    suspend fun postBookmarked(@Path("$SPACE_ID") spaceId: Int): NullResponse

    @DELETE("/$BOOKMARK/$SPACE/{$SPACE_ID}")
    suspend fun deleteBookmarked(@Path("$SPACE_ID") spaceId: Int): NullResponse

    @GET("$SPACE/{$SPACE_ID}")
    suspend fun getSpaceDetail(@Path("$SPACE_ID") spaceId: Int): BaseResponseNullable<SpaceDetailData>

    @GET("$SPACE/{$SPACE_ID}/$BOOK")
    suspend fun getCuration(@Path("$SPACE_ID") spaceId: Int): BaseResponseNullable<List<CurationData>>

    @GET("$SPACE/{$SPACE_ID}/$FOLLOW")
    suspend fun getFollow(@Path("$SPACE_ID") spaceId: Int): BaseResponse<FollowData>

    @POST("$SPACE/{$SPACE_ID}/$FOLLOW")
    suspend fun postFollow(@Path("$SPACE_ID") spaceId: Int): NullResponse

    @GET("$SPACE/{$SPACE_ID}/$ARTICLE")
    suspend fun getSpaceArticle(@Path("$SPACE_ID") spaceId: Int): BaseResponseNullable<SpaceArticleData>
}