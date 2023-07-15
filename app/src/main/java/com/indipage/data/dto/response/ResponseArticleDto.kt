package com.indipage.data.dto.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ResponseArticleDto(
    @SerialName("spaceName")
    val spaceName: String,
    @SerialName("title")
    val title: String,
    @SerialName("spaceType")
    val spaceType: String,
    @SerialName("id")
    val id: Int,
    @SerialName("issueDate")
    val issueDate: String,
    @SerialName("thumbnailUrl")
    val thumbnailUrl:String,
    @SerialName("ticketReceived")
    val ticketReceived: Boolean,
)
