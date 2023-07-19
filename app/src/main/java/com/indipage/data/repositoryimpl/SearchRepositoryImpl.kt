package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SearchDataSource
import com.indipage.data.dto.response.ResponseSearchData
import com.indipage.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override suspend fun getSearchResult(keyword: String?): Result<List<ResponseSearchData>> {
        return runCatching {
            dataSource.getSearchResult(keyword).data
        }
    }
}