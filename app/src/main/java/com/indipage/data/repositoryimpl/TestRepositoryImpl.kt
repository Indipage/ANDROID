package com.indipage.data.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.indipage.data.api.TestApi
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.dto.request.RequestTestDto
import com.indipage.data.dto.ResponseTestDto
import com.indipage.data.dto.response.TestRecyclerviewImage
import com.indipage.domain.repository.TestApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val apiService: TestApi
) : TestApiRepository {
    override fun getRecyclerviewTest(query: String): Flow<PagingData<TestRecyclerviewImage>> =
        Pager(PagingConfig(10)) {
            TestDataSource(apiService)
        }.flow

    override suspend fun test(requestTestDto: RequestTestDto): Result<ResponseTestDto?> = runCatching {
        apiService.test(requestTestDto).body()
    }


}