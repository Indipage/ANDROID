package com.indipage.data.dto.response

import com.indipage.domain.model.Search
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchData(
    @SerialName("spaceId")
    val spaceId: Int,
    @SerialName("spaceName")
    val spaceName: String,
    @SerialName("address")
    val address: String,
    @SerialName("imageUrl")
    val imageUrl: String?
) {
    fun toSearch() = run {
        Search(spaceId, spaceName, address, imageUrl)
    }
}