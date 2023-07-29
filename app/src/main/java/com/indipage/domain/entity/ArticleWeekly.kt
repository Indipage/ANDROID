package com.indipage.domain.entity

data class ArticleWeekly(
    val id: Int,
    val title: String,
    val spaceName: String,
    val spaceOwner: String,
    val remainingDays: Int,
    val thumbnailUrlOfThisWeek: String,
    val thumbnailUrlOfNextWeek: String
)