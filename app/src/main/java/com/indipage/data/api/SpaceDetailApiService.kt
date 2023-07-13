package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.CurationData
import com.indipage.data.dto.response.SpaceDetailData
import retrofit2.http.*

interface SpaceDetailApiService {
    @GET("space/{spaceId}")
    suspend fun getSpaceDetail(@Path("spaceId") spaceId: Int): BaseResponse<SpaceDetailData>

    @GET("space/{spaceId}/book")
    suspend fun getCuration(@Path("spaceId") spaceId: Int): BaseResponse<List<CurationData> >

}