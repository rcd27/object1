package com.objectone.toothpick.network

import okhttp3.OkHttpClient
import toothpick.config.Module

class NetworkModule : Module() {
    init {
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java).providesSingletonInScope()
    }
}
