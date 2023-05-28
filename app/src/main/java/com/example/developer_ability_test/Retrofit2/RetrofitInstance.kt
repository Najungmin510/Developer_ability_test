package com.example.developer_ability_test.Retrofit2

import com.example.developer_ability_test.BaseUrl.Constants.Companion.BASE_URL
import com.example.developer_ability_test.InterfaceFile.RetrofitService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    val LoginApi : RetrofitService by lazy{
        retrofit.create(RetrofitService::class.java)
    }

    val PostsApi : RetrofitService by lazy{
        retrofit.create(RetrofitService::class.java)
    }

    val TodoApi : RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}
