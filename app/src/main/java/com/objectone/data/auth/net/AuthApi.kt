package com.objectone.data.auth.net

import com.objectone.core.auth.data.AuthData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {
    @GET("{phone}")
    fun getAuthData(@Query("phone") phone: String): Single<AuthData>
}