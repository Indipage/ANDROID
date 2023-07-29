package com.indipage.data.repositoryimpl

import com.indipage.data.datasource.SearchDataSource
import com.indipage.domain.entity.Search
import com.indipage.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override suspend fun getSearchResult(keyword: String?): Result<List<Search>?> {
        return runCatching {
            dataSource.getSearchResult(keyword).data?.map { responseSearchData -> responseSearchData.toSearch() }
        }
    }
}