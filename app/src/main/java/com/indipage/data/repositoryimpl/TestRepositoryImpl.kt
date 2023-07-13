package com.indipage.data.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.indipage.data.api.TestApiService
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.datasource.TestPagingSource
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseSignInDto
import com.indipage.data.dto.response.TestRecyclerviewImage
import com.indipage.domain.repository.TestApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val apiService: TestApiService,
    private val dataSource: TestDataSource
) : TestApiRepository {
    override fun getRecyclerviewTest(query: String): Flow<PagingData<TestRecyclerviewImage>> =
        Pager(PagingConfig(10)) {
            TestPagingSource(apiService)
        }.flow

    override suspend fun singIn(requestSignInDto: RequestSignInDto): Result<ResponseSignInDto> {
        return runCatching {
            dataSource.singIn(requestSignInDto).data!!
        }
    }

}