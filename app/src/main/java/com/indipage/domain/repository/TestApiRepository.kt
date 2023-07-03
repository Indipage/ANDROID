package com.indipage.domain.repository

import androidx.paging.PagingData
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.ResponseSignInDto
import com.indipage.data.dto.kakao.KaKaoImage
import kotlinx.coroutines.flow.Flow

interface TestApiRepository {
    fun getRecyclerviewTest(query:String): Flow<PagingData<KaKaoImage>>
    suspend fun singIn(requestSignInDto: RequestSignInDto): Result<ResponseSignInDto?>

}