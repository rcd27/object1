package com.objectone.toothpick.auth

import com.objectone.data.auth.net.AuthApi
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class AuthApiProvider @Inject constructor(private val okHttpClient: OkHttpClient) : Provider<AuthApi> {
    override fun get(): AuthApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/rcd27/object1/master/rest_api/auth/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

        return retrofit.create(AuthApi::class.java)
    }
}