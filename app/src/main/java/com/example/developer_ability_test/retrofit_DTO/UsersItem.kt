package com.example.developer_ability_test.retrofit_DTO


import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username") //닉네임
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String

)