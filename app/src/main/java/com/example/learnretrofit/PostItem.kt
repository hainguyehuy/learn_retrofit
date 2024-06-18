package com.example.learnretrofit

import com.google.gson.annotations.SerializedName

data class PostItem(
    @SerializedName("id")
    val id : Int,

    @SerializedName("userId")
    val userId : Int,

    @SerializedName("title")
    val title : String,

    @SerializedName("body")
    val body : String,
)
