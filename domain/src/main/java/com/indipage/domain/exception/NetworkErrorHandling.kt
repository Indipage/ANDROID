package com.indipage.domain.exception

sealed class NetworkErrorHandling {
    object Unauthorized : NetworkErrorHandling()
    object ServerError : NetworkErrorHandling()
    object OtherError : NetworkErrorHandling()
}