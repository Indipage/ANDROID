package com.indipage.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseCurationDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: CurationData?
) {
    @Serializable
    data class CurationData(
        @SerialName("comment")
        val comment: String,
        @SerialName("book")
        val bookData: BookData
    ) {
        @Serializable
        data class BookData(
            @SerialName("id")
            val id: Int,
            @SerialName("title")
            val title: String,
            @SerialName("imageUrl")
            val imageUrl: String
        )
    }
}