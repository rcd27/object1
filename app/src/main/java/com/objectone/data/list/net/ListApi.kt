package com.objectone.data.list.net

import com.objectone.core.list.data.ObjectOneItem
import io.reactivex.Single
import retrofit2.http.GET

interface ListApi {

    @GET("data")
    fun getObjects(): Single<List<ObjectOneItem>>
}