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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import com.example.developer_ability_test.InterfaceFile.RetrofitService
import com.example.developer_ability_test.R
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.Retrofit2.RetrofitInstance
import com.example.developer_ability_test.ViewModel.MainViewModel
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.databinding.ActivityLoginMainBinding
import com.example.developer_ability_test.fragments.notice_fragment
import com.example.developer_ability_test.retrofit_DTO.PostsItem
import com.example.developer_ability_test.retrofit_DTO.Users
import com.example.developer_ability_test.retrofit_DTO.UsersItem
import retrofit2.Response

/*
parcelize 참고  : https://yuuj.tistory.com/211 https://ducksever.tistory.com/31
> 안내사항 알려줄 때 다이얼로그 사용하면됨 ( 처음 구현하는거라 구글 검색해서 다시 확인할 것)
> 게시판으로 데이터 넘겨주고 게시판에서 넘어온 데이터 할일로 넘겨주기
> 화면전환 intent, 데이터 넘기기 bundle 사용
*/

class Login_MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMainBinding //결합 클래스 호출
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var userName = ""

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]


        viewModel.LoginUserResponse.observe(this, Observer {
            if(it.isSuccessful){
                it.body()?.forEach{
                    //Log.d("테스트", it.name)
                    if(it.name == ""){
                        Toast.makeText(this,"회원 목록에 존재하지 않습니다.",Toast.LENGTH_SHORT).show()

                    } else {
                        val intent = Intent(this,btm_navigation::class.java)
                        Toast.makeText(this,"로그인 하였습니다.",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }
                }
            } else{
                Log.d("Response",it.errorBody().toString())
            }
        })

        binding.btnLogin.setOnClickListener {
            userName = binding.etUserId.text.toString()//사용자에게서 입력받은 string으로 name을 가져오기
            if(userName == ""){
                Toast.makeText(this,"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show()
            } else{
                viewModel.getLogin(userName)
            }
        }
   }// override
}
