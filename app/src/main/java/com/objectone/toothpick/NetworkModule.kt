package com.objectone.toothpick

import com.objectone.data.net.Api
import toothpick.config.Module
import javax.inject.Qualifier

class NetworkModule(baseUrl: String) : Module() {
    init {
        bind(String::class.java).withName(BaseUrl::class.java).toInstance(baseUrl)
        bind(Api::class.java).toProvider(ApiProvider::class.java).providesSingletonInScope()
    }
}

@Qualifier annotation class BaseUrl
