package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FollowData(
    @SerialName("isFollowed")
    val isFollowed: Boolean
)

@Serializable
data class BookmarkData(
    @SerialName("bookmarked")
    val bookmarked: Boolean
)