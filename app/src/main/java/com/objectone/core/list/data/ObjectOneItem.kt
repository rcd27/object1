package com.objectone.core.list.data

import com.google.gson.annotations.SerializedName

data class ObjectOneItem(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("image") val image: String
)