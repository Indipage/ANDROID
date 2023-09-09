package com.indipage.ui.articledetail

import android.text.SpannableStringBuilder

data class ArticleDetailData(
    val body: String, val spaceId: Long
)

data class ArticleDetailParsing(
    val title: String?,
    val image: String?,
    val body: SpannableStringBuilder?,
    val line: Boolean,
    val spaceId: Long
)
