package com.example.developer_ability_test.code

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.ActivityLoginMainBinding
import com.example.developer_ability_test.retrofit_login.LoginService
import com.example.developer_ability_test.retrofit_login.Login_RetrofitObject
import com.example.developer_ability_test.retrofit_login.Login_Users
import retrofit2.Response
import retrofit2.create

// ?? 왜 안대징 ???????
class Login_MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMainBinding //결합 클래스 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val user_name = binding.etUserId.text.toString(); //사용자에게서 입력받은 string으로 name을 가져오기

        val RetService = Login_RetrofitObject //retrofit 객체 생성
            .get_Login_RetrofitObject()
            .create(LoginService::class.java)

        val responseLiveData : LiveData<Response<Login_Users>> = liveData{
            val response = RetService.getUserName(user_name) //사용자에게 받은 이름을 인자로 넘겨줌
            emit(response)
        }

        responseLiveData.observe((this, Observer{
            val data = it.body()?.
        })

        //버튼 클릭, 로그인 이벤트 시작
        binding.btnLogin.setOnClickListener{ //버튼 클릭시

            val Notice_Intent = Intent(this, Notice_MainActivity::class.java)
            val Todo_Intent = Intent(this, Todo_MainActivity::class.java)


            startActivity(Notice_Intent)
            startActivity(Todo_Intent)

            Toast.makeText(this,"로그인 하였습니다.",Toast.LENGTH_SHORT).show()


            })

        }
    }
