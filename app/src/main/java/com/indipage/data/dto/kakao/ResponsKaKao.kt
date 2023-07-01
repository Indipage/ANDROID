package org.android.go.sopt.data.model.kakao


import com.indipage.data.dto.kakao.KaKaoImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponsKaKao(
    @SerialName("documents")
    val documents: List<KaKaoImage>,
    @SerialName("meta")
    val meta: Meta
)