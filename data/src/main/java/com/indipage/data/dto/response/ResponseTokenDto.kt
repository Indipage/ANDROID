package com.indipage.data.dto.response


import com.indipage.domain.model.Token
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTokenDto(
    @SerialName("accessToken") val accessToken: String
)

fun ResponseTokenDto.toTokenEntity() = Token(accessToken)


