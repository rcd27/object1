package com.objectone.core.auth.data

import com.google.gson.annotations.SerializedName

data class AuthData(
        @SerializedName("user") val user: String,
        @SerializedName("session") val session: String
)