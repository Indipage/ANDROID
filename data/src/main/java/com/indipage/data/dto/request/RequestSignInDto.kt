package com.indipage.data.dto.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignInDto(
    @SerializedName("accessToken")  val accessToken: String,
    @SerializedName("platform")  val platform: String
)