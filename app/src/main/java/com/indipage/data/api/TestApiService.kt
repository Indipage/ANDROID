package com.indipage.data.api

import com.indipage.data.dto.BaseResponse
import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.response.ResponseArticleDetailDto
import com.indipage.data.dto.response.ResponseSignInDto
import com.indipage.data.dto.response.ResponseTestRecyclerview
import retrofit2.Response
import retrofit2.http.*

interface TestApiService {
    @GET("test-recyclerview")
    suspend fun getTestApi(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ResponseTestRecyclerview>

    @POST("sign-in")
    suspend fun singIn(@Body requestSignUpDto: RequestSignInDto): BaseResponse<ResponseSignInDto>

    /**
     *     만약 path 밑에 예제처럼 코드가 있다면 @Path 어노테이션 사용하셈!
     *     @POST("test/{path}")
     *     suspend fun test(
     *     @Body requestSignUpDto: RequestTestDto,
     *     @Path("path") path:String
     *     ): Response<ResponseTestDto>
     * **/

}