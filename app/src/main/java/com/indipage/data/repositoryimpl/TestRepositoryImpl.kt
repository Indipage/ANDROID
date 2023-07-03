package com.indipage.data.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.indipage.data.api.TestApi
import com.indipage.data.datasource.TestDataSource
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.ResponseSignInDto
import com.indipage.data.dto.kakao.KaKaoImage
import com.indipage.domain.repository.TestApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val apiService: TestApi
) : TestApiRepository {
    override fun getRecyclerviewTest(query: String): Flow<PagingData<KaKaoImage>> =
        Pager(PagingConfig(10)) {
            TestDataSource(apiService, query)
        }.flow

    override suspend fun singIn(requestSignInDto: RequestSignInDto): Result<ResponseSignInDto?> = runCatching {
        apiService.singIn(requestSignInDto).body()
    }


}