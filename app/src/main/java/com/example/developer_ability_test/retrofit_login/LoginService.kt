package com.example.developer_ability_test.retrofit_login

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {

    @GET("/users")
    fun getUserName(
        @Query("name") name : String)
    :Response<Login_Users>
}