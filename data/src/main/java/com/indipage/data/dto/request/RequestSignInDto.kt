package com.indipage.data.dto.request

import com.google.gson.annotations.SerializedName

data class RequestSignInDto(
    @SerializedName("accessToken") private val accessToken: String,
    @SerializedName("platform") private val platform: String
)