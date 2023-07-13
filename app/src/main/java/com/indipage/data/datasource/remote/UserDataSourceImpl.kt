package com.indipage.data.datasource.remote

import com.indipage.data.api.UserApiService
import com.indipage.data.datasource.UserDataSource
import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.response.UserResponseDto
import javax.inject.Inject

class UserDataSourceImpl  @Inject constructor(
    private val apiService: UserApiService
) : UserDataSource {

    override suspend fun getUserInfo(): BaseResponse<UserResponseDto> {
        return apiService.getUserInfo()
    }

}