package com.indipage.domain.repository

import com.indipage.domain.entity.Search

interface SearchRepository {
    suspend fun getSearchResult(keyword: String?): Result<List<Search>?>
}