package com.indipage.domain.exception

import java.lang.RuntimeException

class IndipageHttpException(
    val httpCode: Int,
    override val message: String,
) : RuntimeException()