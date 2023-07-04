package com.indipage.domain.repository

import androidx.paging.PagingData
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseSignInDto
import com.indipage.data.dto.response.TestRecyclerviewImage
import kotlinx.coroutines.flow.Flow

interface TestApiRepository {
    fun getRecyclerviewTest(query: String): Flow<PagingData<TestRecyclerviewImage>>
    suspend fun singIn(requestSignInDto: RequestSignInDto): Result<ResponseSignInDto>


}