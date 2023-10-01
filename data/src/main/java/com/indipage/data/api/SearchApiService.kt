package com.indipage.data.api

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseSearchData
import retrofit2.http.*

interface SearchApiService {
    companion object {
        const val SPACE = "space"
        const val LIST = "list"
    }

    @GET("/$SPACE/$LIST")
    suspend fun getSearchResult(@Query("keyword") keyword: String?): BaseResponseNullable<List<ResponseSearchData>>
}