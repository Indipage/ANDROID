package com.indipage.data.dto.response

import com.indipage.domain.entity.ArticleSlide
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseArticleSlideDto(
    @SerialName("hasSlide")
    val hasSlide: Boolean
) {
    fun toArticleSlideEntity() = ArticleSlide(hasSlide)
}
