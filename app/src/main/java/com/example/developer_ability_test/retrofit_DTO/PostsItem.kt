package com.example.developer_ability_test.retrofit_DTO


import com.google.gson.annotations.SerializedName

data class PostsItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId") //유저 고유 아이디
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)