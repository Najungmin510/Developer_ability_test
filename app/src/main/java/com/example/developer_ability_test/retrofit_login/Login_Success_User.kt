package com.example.developer_ability_test.retrofit_login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize //직렬화 시켜서 로그인한 회원 객체 자체를 넘겨버릴거임


//Kotlin val var 헷갈리지 말 것 val은 데이터 고정임

@Parcelize
data class Login_Success_User( //로그인 한 사용자 정보를 저장할 class

    var Success_user_name : String,
    var Success_user_id : Int

) : Parcelable



