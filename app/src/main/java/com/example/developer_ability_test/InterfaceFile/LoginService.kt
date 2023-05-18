package com.example.developer_ability_test.InterfaceFile

import com.example.developer_ability_test.retrofit_login.Users
import retrofit2.Response
import retrofit2.http.GET

interface LoginService {
    @GET("/users")
    suspend fun getUsers() : Response<Users>

}