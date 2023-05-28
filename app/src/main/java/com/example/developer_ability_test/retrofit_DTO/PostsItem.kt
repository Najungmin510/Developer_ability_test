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
    val body: String,

    val type : Int //로그인 한 유저의 게시글, 로그인 하지 않은 유저의 게시글을 구분하기 위해서 type 추가
)