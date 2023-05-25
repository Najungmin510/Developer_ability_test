package com.example.developer_ability_test.code

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import com.example.developer_ability_test.InterfaceFile.RetrofitService
import com.example.developer_ability_test.R
import com.example.developer_ability_test.Retrofit2.RetrofitInstance
import com.example.developer_ability_test.databinding.ActivityLoginMainBinding
import com.example.developer_ability_test.fragments.notice_fragment
import com.example.developer_ability_test.retrofit_DTO.LoginInform
import com.example.developer_ability_test.retrofit_DTO.Users
import retrofit2.Response

/*
parcelize 참고  : https://yuuj.tistory.com/211 https://ducksever.tistory.com/31
> 안내사항 알려줄 때 다이얼로그 사용하면됨 ( 처음 구현하는거라 구글 검색해서 다시 확인할 것)
> 게시판으로 데이터 넘겨주고 게시판에서 넘어온 데이터 할일로 넘겨주기
> 화면전환 intent, 데이터 넘기기 bundle 사용
*/

class Login_MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMainBinding //결합 클래스 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val userName = binding.etUserId.text//사용자에게서 입력받은 string으로 name을 가져오기

        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(RetrofitService::class.java)

        val responseLiveData : LiveData<Response<Users>> = liveData {
            val response = retService.getUsers()
            emit(response)
        }


        val btn = binding.btnLogin //로그인 버튼 가져오기

        btn.setOnClickListener{ //버튼 클릭 시

            responseLiveData.observe(this, Observer {
                val UserList = it.body()
                //Log.d("ID / 사용자 입력 아이디",userName.toString())

                var check = false //회원 목록에 있는지 확인할 변수
                var login_name = "" //로그인 한 사용자 이름
                var login_id = 0 //로그인 한 사용자 아이디

                if (UserList != null) {
                    for(i in 0 until UserList.size){ //사용자 적어서 그냥 다 돌아버릴거임
                        if(userName.toString() == UserList.get(i).name){ //입력한 값과 같은게 목록에 있다면 회원
                            check = true;
                            login_name = UserList.get(i).name
                            login_id = UserList.get(i).id

                            //Log.d("ID/ 찾은 사용자 이름", login_name)
                            //Log.d("ID/ 찾은 사용자 아이디", login_id.toString())

                        }
                    }
                } //No Problem

                if(check == true){ //회원 여부 확인
                    val intentContent = Intent(this, btm_navigation::class.java) //작동은 main에서 되기때문에 사용자에게 보여지는 화면은 main으로 이동

                    //val bundle = bundleOf(login_name to login)



                    Toast.makeText(this,"로그인 하였습니다.",Toast.LENGTH_LONG).show()
                    startActivity(intentContent)

                } else{ //아니라면 회원 x, 로그인 불가
                    Toast.makeText(this,"해당 아이디가 존재하지 않습니다.",Toast.LENGTH_LONG).show()

                }
            })
        }

   }// override
}
