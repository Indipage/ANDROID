package com.indipage.model

import com.indipage.domain.model.Article
import com.indipage.domain.model.UserInfo

data class ArticleModel (
    val spaceName: String,
    val title: String,
    val spaceType: String,
    val id: Int,
    val issueDate: String,
    val thumbnailUrl: String,
    val ticketReceived: Boolean,
)
fun Article.toArticleModelEntity() = ArticleModel(
    spaceName, title, spaceType, id, issueDate, thumbnailUrl, ticketReceived
)