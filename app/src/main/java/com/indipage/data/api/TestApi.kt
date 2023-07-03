package com.indipage.data.api

import com.indipage.data.dto.request.RequestSignInDto
import com.indipage.data.dto.ResponseSignInDto
import org.android.go.sopt.data.model.kakao.ResponsKaKao
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TestApi {
    @GET("/v2/search/image")
    suspend fun getTestApi(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ResponsKaKao>

    @POST("sign-in")
    suspend fun singIn(@Body requestSignUpDto: RequestSignInDto): Response<ResponseSignInDto>

}