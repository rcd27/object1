package com.objectone.auth

import com.objectone.data.auth.net.AuthApi
import toothpick.config.Module

class AuthModule : Module() {
    init {
        bind(AuthApi::class.java).toProvider(AuthApiProvider::class.java).providesSingletonInScope()
    }
}