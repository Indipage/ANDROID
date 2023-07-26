package com.indipage.data.dto.response

import com.indipage.domain.entity.Space
import com.indipage.domain.entity.Ticket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSpaceDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("imageUrl")
    val imageUrl:String ,
    @SerialName("address")
    val roadAddress: String,
){
    fun toSpaceEntity() = Space(
        id,name,imageUrl,roadAddress
    )
}
