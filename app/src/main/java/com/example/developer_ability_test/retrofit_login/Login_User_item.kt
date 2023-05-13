package com.example.developer_ability_test.retrofit_login

import com.google.gson.annotations.SerializedName

data class Login_User_item (

    @SerializedName("id")
    val id : Int,

    @SerializedName("name")
    val name : String

    )
