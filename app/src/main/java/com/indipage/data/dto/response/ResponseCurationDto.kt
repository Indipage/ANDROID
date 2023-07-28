package com.indipage.data.dto.response

import com.indipage.domain.entity.Book
import com.indipage.domain.entity.Curation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CurationData(
    @SerialName("book")
    val bookData: BookData,
    @SerialName("comment")
    val comment: String
) {
    @Serializable
    data class BookData(
        @SerialName("id")
        val id: Int,
        @SerialName("title")
        val title: String,
        @SerialName("imageUrl")
        val imageUrl: String
    ) {
        fun toBook() = run {
            Book(id, title, imageUrl)
        }
    }

    fun toCuration() = run {
        Curation(bookData.toBook(), comment)
    }
}
