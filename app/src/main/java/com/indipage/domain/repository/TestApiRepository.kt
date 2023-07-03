package com.indipage.domain.repository

import androidx.paging.PagingData
import com.indipage.data.dto.request.RequestTestDto
import com.indipage.data.dto.ResponseTestDto
import com.indipage.data.dto.response.TestRecyclerviewImage
import kotlinx.coroutines.flow.Flow

interface TestApiRepository {
    fun getRecyclerviewTest(query:String): Flow<PagingData<TestRecyclerviewImage>>
    suspend fun test(requestTestDto: RequestTestDto): Result<ResponseTestDto?>

}