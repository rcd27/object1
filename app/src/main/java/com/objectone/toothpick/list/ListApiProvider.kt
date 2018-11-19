package com.objectone.toothpick.list

import com.objectone.data.list.net.ListApi
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.createWithScheduler
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class ListApiProvider @Inject constructor(private val client: OkHttpClient) : Provider<ListApi> {
    override fun get(): ListApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/rcd27/object1/master/rest_api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(createWithScheduler(Schedulers.io()))
                .build()

        return retrofit.create(ListApi::class.java)
    }
}
