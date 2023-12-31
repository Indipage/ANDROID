package com.indipage.util

object API {
    const val API_TAG = "Retrofit2"
}

object ArticleDetailTag {
    const val TITLE = 0
    const val IMAGE = 1
    const val BODY = 2
    const val LINE = 3
    val IMAGE_TAG_REGEX = "(<img>.*?</img>)".toRegex()
    val TITLE_TAG_REGEX = "(<title>.*?</title>)".toRegex()
    val BOLD_TAG_REGEX = "(<bold>.*?</bold>)".toRegex()
    val COLOR_TAG_REGEX = "(<color>.*?</color>)".toRegex()
    val LINK_TAG_REGEX = "(<link>.*?</link>)".toRegex()
    val LINE_TAG_REGEX = "(<hr>.*?</hr>)".toRegex()
    val REPLACE_TAG_REGEX = "(<img>|</img>|<title>|</title>|<body>|</body>)".toRegex()
    val REPLACE_STYLE_START_TAG_REGEX = "(((<bold>)?(<color>)?(<link>)?)+)".toRegex()
    val REPLACE_STYLE_END_TAG_REGEX = "(((</link>)?(</bold>)?(</color>)?)+)".toRegex()
    val TAG_REGEX = "(<img>.*?</img>|<title>.*?</title>|<body>.*?</body>|<hr>*?</hr>)".toRegex()
}

object WeeklyArticle {
    const val ITEM_OPEN = 0
    const val ITEM_PRE = 1
    const val KEY_ARTICLE_ID = "articleId"
}

