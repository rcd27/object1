package com.objectone.data.auth.net

import com.objectone.core.auth.data.AuthData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
    @GET("{phone}")
    fun getAuthData(@Path("phone") phone: String): Single<AuthData>
}