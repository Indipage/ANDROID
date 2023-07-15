package com.indipage.util

object API {
    const val API_TAG = "Retrofit2"
}

object ArticleDetailTag{
    const val TITLE = 0
    const val IMAGE = 1
    const val BODY = 2

    val IMAGE_TAG_REGEX = "(<img>.*?</img>)".toRegex()
    val TITLE_TAG_REGEX = "(<title>.*?</title>)".toRegex()
    val BODY_TAG_REGEX = "(<body>.*?</body>)".toRegex()
    val BOLD_TAG_REGEX = "(<bold>.*?</bold>)".toRegex()
    val COLOR_TAG_REGEX = "(<color>.*?</color>)".toRegex()
    val CLICK_TAG_REGEX = "(<click>.*?</click>)".toRegex()
    val REPLACE_TAG_REGEX = "(<img>|</img>|<title>|</title>|<body>|</body>)".toRegex()
    val REPLACE_STYLE_START_TAG_REGEX = "(((<bold>)?(<color>)?(<click>)?)+)".toRegex()
    val REPLACE_STYLE_END_TAG_REGEX = "(((</click>)?(</bold>)?(</color>)?)+)".toRegex()
}

object WeeklyArticle{
    const val ITEM_OPEN = 0
    const val ITEM_PRE = 1
}