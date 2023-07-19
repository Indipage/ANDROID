package com.indipage.domain.repository

import com.indipage.data.dto.response.ResponseSearchData

interface SearchRepository {
    suspend fun getSearchResult(keyword: String?): Result<List<ResponseSearchData>>
}