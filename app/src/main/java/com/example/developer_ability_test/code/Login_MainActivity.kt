package com.example.developer_ability_test.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.ActivityLoginMainBinding
import com.example.developer_ability_test.retrofit_login.LoginService
import com.example.developer_ability_test.retrofit_login.Login_RetrofitObject
import com.example.developer_ability_test.retrofit_login.Login_Users
import kotlinx.coroutines.flow.internal.NopCollector.emit
import retrofit2.Response
import retrofit2.create

class Login_MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMainBinding //결합 클래스 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = binding.etUserId.text.toString(); //사용자에게서 입력받은 string으로 name을 가져오기

        val RetService = Login_RetrofitObject //retrofit 객체 생성
            .get_Login_RetrofitObject()
            .create(LoginService::class.java)

        val responseLiveData : LiveData<Response<Login_Users>> = livedata{
            val response = RetService.getUserName(name)
            emit(response)
        }

        //버튼 클릭, 로그인 이벤트 시작
        binding.btnLogin.setOnClickListener{ //버튼 클릭시

        }


    }
}