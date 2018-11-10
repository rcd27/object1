package com.objectone.data.net

import com.objectone.core.list.data.ObjectOneItem
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET("data")
    fun getObjects(): Single<List<ObjectOneItem>>
}