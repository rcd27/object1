package com.objectone

import com.objectone.core.list.data.ObjectOneItem
import com.objectone.data.net.Api
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MockWebServerTest {

    @Test
    fun mainCase() {
        val server = MockWebServer()
        val mockResponse = MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .setBody("[{\"id\":\"1\",\"title\":\"Wasup\",\"image\":\"IMAAAGE\"}]");
        server.enqueue(mockResponse)
        server.start()

        // TODO: this should be injected here
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
                .baseUrl(server.url(""))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        val api = retrofit.create(Api::class.java)

        assertThat(api.getObjects().blockingGet(), hasItem(ObjectOneItem("1", "Wasup", "IMAAAGE")))
        server.shutdown()
    }
}