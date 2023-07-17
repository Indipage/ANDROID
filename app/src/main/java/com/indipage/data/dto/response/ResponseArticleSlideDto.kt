package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseArticleSlideDto(
    @SerialName("hasSlide")
    val hasSlide: Boolean
)
