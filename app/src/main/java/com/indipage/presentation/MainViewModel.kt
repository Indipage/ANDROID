package com.indipage.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.TestRecyclerviewImage
import com.indipage.domain.repository.TestApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class MainViewModel @Inject constructor(
    private val apiRepository: TestApiRepository
) : ViewModel() {
    fun getRecyclerviewTest(query: String): Flow<PagingData<TestRecyclerviewImage>> =
        apiRepository.getRecyclerviewTest(query)

    fun test(requestTestDto: RequestSignInDto) = viewModelScope.launch {
        apiRepository.singIn(requestTestDto)
            .onSuccess { Log.d("test", "success") }
            .onFailure { Log.d("test", "fail") }
    }

}