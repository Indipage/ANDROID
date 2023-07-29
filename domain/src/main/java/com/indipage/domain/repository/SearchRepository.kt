package com.indipage.domain.repository

import com.indipage.domain.model.Search

interface SearchRepository {
    suspend fun getSearchResult(keyword: String?): Result<List<Search>?>
}