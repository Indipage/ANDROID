package com.indipage.data.api

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseSearchData
import retrofit2.http.*

interface SearchApiService {
    @GET("/space/list")
    suspend fun getSearchResult(@Query("keyword") keyword: String?): BaseResponseNullable<List<ResponseSearchData>>
}