package com.example.developer_ability_test.code

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.ActivityLoginMainBinding
import com.example.developer_ability_test.retrofit_login.LoginService
import com.example.developer_ability_test.retrofit_login.Login_RetrofitObject
import com.example.developer_ability_test.retrofit_login.Login_Success_User
import com.example.developer_ability_test.retrofit_login.Login_Users
import retrofit2.Response
import retrofit2.create
/*
parcelize 참고  : https://yuuj.tistory.com/211 https://ducksever.tistory.com/31
> 안내사항 알려줄 때 다이얼로그 사용하면됨 ( 처음 구현하는거라 구글 검색해서 다시 확인할 것)

*/


class Login_MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMainBinding //결합 클래스 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val userName = binding.etUserId.text.toString(); //사용자에게서 입력받은 string으로 name을 가져오기

        val retService = Login_RetrofitObject //retrofit 객체 생성
            .get_Login_RetrofitObject()
            .create(LoginService::class.java)

        val responseLiveData: LiveData<Response<Login_Users>> = liveData {
            val response = retService.getUser() //사용자에 대한 데이터를 가져오고
            emit(response)
        }

        binding.btnLogin.setOnClickListener { //버튼을 클릭했을 때
            responseLiveData.observe(this, Observer {
                val userList = it.body()?.listIterator()

                if (userList != null) { //비어있지 않다면 회원 목록에 있다는 것, 그럼 다음 화면으로 넘어가도 ok
                    while (userList.hasNext()) {
                        val item = userList.next()

                        if (item.name == userName) { //회원 목록중에 있다면 return and break
                            Log.d("로그인 시도 test name", item.name)
                            Log.d("로그인 시도 test id", item.id.toString()) //데이터 확인용 로그

                            val intent: Intent = Intent(this, Notice_MainActivity::class.java)
                            intent.putExtra(
                                "LoginUser",
                                Login_Success_User(item.name, item.id)
                            ) //로그인한 사용자 객체를 넘겨주기
                            startActivity(intent)

                            Toast.makeText(this, "로그인 하였습니다.", Toast.LENGTH_SHORT).show()

                            break //회원은 중복되지 않으니 보낸 후 바로 탈출하면 됨
                        }
                    }
                } else { //null일 경우 회원목록에 없다는 것
                    Toast.makeText(this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show()
                }
            })
        } //Listener

    } // override

}//Main
