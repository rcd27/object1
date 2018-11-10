package com.objectone.toothpick.network

import com.objectone.data.net.Api
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.createWithScheduler
import javax.inject.Inject
import javax.inject.Provider

class ApiProvider @Inject constructor(@BaseUrl val baseUrl: String) : Provider<Api> {
    override fun get(): Api {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(createWithScheduler(Schedulers.io()))
                .build()

        return retrofit.create(Api::class.java)
    }
}
