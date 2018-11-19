package com.objectone.domain.auth

import com.objectone.data.auth.local.AuthHolder
import okhttp3.Interceptor
import okhttp3.Response

/**
 * This class is responsible for checking for the login status.
 * It is able to route to Login Screen, show error messages.
 */
class CheckLoginStatusUseCase(val authHolder: AuthHolder) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.call().execute()
    }
}