package com.example.developer_ability_test.retrofit_login

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


//서비스 인터페이스

interface LoginService {
    @GET("/users")
    fun getUser():Response<Login_Users>

    //@Query("name") name : String
}