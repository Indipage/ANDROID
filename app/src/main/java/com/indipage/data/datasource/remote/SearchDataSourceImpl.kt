package com.indipage.data.datasource.remote

import com.indipage.data.api.SearchApiService
import com.indipage.data.datasource.SearchDataSource
import com.indipage.data.dto.BaseResponseNullable
import com.indipage.data.dto.response.ResponseSearchData
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private val apiService: SearchApiService
) : SearchDataSource {
    override suspend fun getSearchResult(keyword: String?): BaseResponseNullable<List<ResponseSearchData>> {
        return apiService.getSearchResult(keyword)
    }
}