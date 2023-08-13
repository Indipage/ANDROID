package com.indipage.domain.usecase


import com.indipage.domain.model.Search
import com.indipage.domain.repository.SearchRepository

class SearchUseCase(
    private val repository: SearchRepository
) {
    suspend fun getSearchResult(keyword: String?): Result<List<Search>?> =
        repository.getSearchResult(keyword)
}