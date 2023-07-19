package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.ResponseSearchData

interface SearchDataSource {
    suspend fun getSearchResult(keyword: String?): BaseResponse<List<ResponseSearchData>>
}