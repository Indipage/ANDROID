package com.indipage.util

object API {
    const val API_TAG = "Retrofit2"
    const val REQRES_BASE_URL = "https://reqres.in/"
    const val SIGN_IN = "sign-in"
    const val SIGN_UP = "sign-up"
    const val HOME_USER = "api/users"
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
    val REPLACE_STYLE_TAG_REGEX = "(<bold>|</bold>|<color>|</color>|<click>|</click>)".toRegex()
}