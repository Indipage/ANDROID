package com.indipage.data.datasource

import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseSearchData

interface SearchDataSource {
    suspend fun getSearchResult(keyword: String?): BaseResponseNullable<List<ResponseSearchData>>
}