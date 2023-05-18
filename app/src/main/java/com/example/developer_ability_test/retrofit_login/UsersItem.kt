package com.example.developer_ability_test.retrofit_login


import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String
)