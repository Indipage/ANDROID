package com.indipage.domain.repository

import androidx.paging.PagingData
import com.indipage.data.dto.kakao.KaKaoImage
import kotlinx.coroutines.flow.Flow

interface TestApiRepository {
    fun getKaKaoResult(query:String): Flow<PagingData<KaKaoImage>>
}