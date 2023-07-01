package com.indipage.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.indipage.data.dto.kakao.KaKaoImage
import com.indipage.domain.repository.TestApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepository: TestApiRepository
) : ViewModel() {
    fun getKaKaoResult(query: String): Flow<PagingData<KaKaoImage>> =
        apiRepository.getKaKaoResult(query)

}