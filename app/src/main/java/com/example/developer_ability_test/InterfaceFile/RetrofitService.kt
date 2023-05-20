package com.example.developer_ability_test.InterfaceFile

import com.example.developer_ability_test.retrofit_DTO.TodosItem
import com.example.developer_ability_test.retrofit_DTO.Users
import com.example.developer_ability_test.retrofit_DTO.UsersItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("/users")
    suspend fun getUsers() : Response<Users>

    @POST("/todos")
    suspend fun uploadTodos(@Body Todos : TodosItem) : Response<TodosItem>
}