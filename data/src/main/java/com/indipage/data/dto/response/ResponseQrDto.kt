package com.indipage.data.dto.response

import com.indipage.domain.model.MainCard
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ResponseQrDto(
    @SerialName("cardImageUrl") val cardImageUrl: String
){
    fun toMainCardEntity() = MainCard(
        cardImageUrl
    )
}