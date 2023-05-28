package com.example.developer_ability_test.Repository

import com.example.developer_ability_test.Retrofit2.RetrofitInstance
import com.example.developer_ability_test.retrofit_DTO.Posts
import com.example.developer_ability_test.retrofit_DTO.PostsItem
import com.example.developer_ability_test.retrofit_DTO.TodosItem
import com.example.developer_ability_test.retrofit_DTO.UsersItem
import retrofit2.Response

class Repository {

    suspend fun getLogin(name : String) : Response<List<UsersItem>> {
        return RetrofitInstance.LoginApi.getUsers(name)
    }

    //로그인한 사용자의 게시글만 가져오기
    suspend fun getLoginPosts(id : Int) : Response<List<PostsItem>> {
        return RetrofitInstance.PostsApi.getLoginPosts(id)
    }

    //로그인한 사용자의 할일 리스트만 가져오기
    suspend fun getLoginTodos(id: Int) : Response<List<TodosItem>>{
        return RetrofitInstance.TodoApi.getLoginTodos(id)
    }
}