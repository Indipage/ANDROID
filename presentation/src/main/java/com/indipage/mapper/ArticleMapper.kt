package com.indipage.mapper

import com.indipage.domain.model.Article
import com.indipage.model.ArticleModel

fun List<Article>.toArticleModelEntity(): List<ArticleModel> = map {
    ArticleModel(
        spaceName = it.spaceName,
        title = it.title,
        spaceType = it.spaceType,
        id = it.id,
        issueDate = it.issueDate,
        thumbnailUrl = it.thumbnailUrl,
        ticketReceived = it.ticketReceived
    )
}
