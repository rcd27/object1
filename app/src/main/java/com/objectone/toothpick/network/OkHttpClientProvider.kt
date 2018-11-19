package com.objectone.toothpick.network

import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor(/*TODO auth interceptor here*/) : Provider<OkHttpClient> {
    override fun get(): OkHttpClient {
        // TODO: add interceptors here: connectivity and auth
        return OkHttpClient.Builder().build()
    }
}