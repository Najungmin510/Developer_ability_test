package com.example.developer_ability_test.retrofit_login

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Login_RetrofitObject { //서버와 통신할 Login Retrofit 객체 생성
    companion object{
        val BASE_URL = "https://jsonplaceholder.typicode.com/" //기본 주소
        fun get_Login_RetrofitObject(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) //gson으로 변경시킬 converter선언
                .build()
        }
    }
}