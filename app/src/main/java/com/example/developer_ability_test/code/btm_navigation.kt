package com.example.developer_ability_test.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.ActivityBtmNavigationBinding

class btm_navigation : AppCompatActivity(){

    private lateinit var mBinding : ActivityBtmNavigationBinding //바텀 네비게이션과 연결

    var Username = "" //로그인한 사용자의 이름
    var Userid = 0 //로그인한 사용자의 id

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBtmNavigationBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        //navigation을 가져오는 host
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.navController

        //바텀 nav 뷰 & 네비게이션 바인딩
        NavigationUI.setupWithNavController(mBinding.btmNavi,navController)


        //데이터 처리 구간
        Username = intent.getStringExtra("LoginUserName").toString()
        Userid = intent.getIntExtra("LoginUserId",0)

        Log.d("myidcheck",Username)
        Log.d("myidcheck", Userid.toString()) //데이터 잘 넘어오는거 확인 완료

    }

    fun LoginUserName(): String { //로그인한 사용자 이름 넘겨주기
        return Username;
    }

    fun LoginUserId() : Int{ //로그인한 사용자 고유 id 넘겨주기
        return Userid
    }


}