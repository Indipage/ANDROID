package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseArticleBookmarkDto(
    @SerialName("bookmarked")
    val bookmarked: Boolean
)
