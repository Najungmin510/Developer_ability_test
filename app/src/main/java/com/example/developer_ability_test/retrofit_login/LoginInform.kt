package com.example.developer_ability_test.retrofit_login
import java.io.Serializable

data class LoginInform ( //최종적으로 로그인 한 유저의 로그인 정보를 저장해주기
    var LoginName: String,
    var LoginId: Int
) : Serializable