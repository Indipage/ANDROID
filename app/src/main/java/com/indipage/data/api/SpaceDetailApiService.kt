package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.QRResponse
import com.indipage.data.dto.response.BookmarkData
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.FollowData
import com.indipage.data.dto.response.SpaceArticleData
import com.indipage.data.dto.response.SpaceDetailData
import retrofit2.http.*

interface SpaceDetailApiService {

    @GET("user/bookmark/space/{spaceId}")
    suspend fun getBookmarked(@Path("spaceId") spaceId: Int): BaseResponse<BookmarkData>

    @POST("user/bookmark/space/{spaceId}")
    suspend fun postBookmarked(@Path("spaceId") spaceId: Int): QRResponse

    @DELETE("user/bookmark/space/{spaceId}")
    suspend fun deleteBookmarked(@Path("spaceId") spaceId: Int): QRResponse

    @GET("space/{spaceId}")
    suspend fun getSpaceDetail(@Path("spaceId") spaceId: Int): BaseResponse<SpaceDetailData>

    @GET("space/{spaceId}/book")
    suspend fun getCuration(@Path("spaceId") spaceId: Int): BaseResponse<List<CurationData>>

    @GET("space/{spaceId}/follow")
    suspend fun getFollow(@Path("spaceId") spaceId: Int): BaseResponse<FollowData>

    @POST("space/{spaceId}/follow")
    suspend fun postFollow(@Path("spaceId") spaceId: Int): QRResponse

    @GET("space/{spaceId}/article")
    suspend fun getSpaceArticle(@Path("spaceId") spaceId:Int): BaseResponseNullable<SpaceArticleData>
}