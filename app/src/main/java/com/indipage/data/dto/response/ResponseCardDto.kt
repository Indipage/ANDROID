package com.indipage.data.dto.response

import com.indipage.domain.entity.Card
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ResponseCardDto(
    @SerialName("cardId")
    val cardId: Long,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("visitedAt")
    val visitedAt: String,
    @SerialName("spaceId")
    val spaceId: Int,
) {
    fun toCardEntity() = Card(
        cardId, imageUrl, visitedAt, spaceId
    )
}
