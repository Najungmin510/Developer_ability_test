package com.example.developer_ability_test.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.ActivityBtmNavigationBinding

class btm_navigation : AppCompatActivity() {

    private lateinit var mBinding : ActivityBtmNavigationBinding //바텀 네비게이션과 연결
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityBtmNavigationBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        //navigation을 가져오는 host
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment

        val navController = navHostFragment.navController

        //바텀 nav 뷰 & 네비게이션 바인딩
        NavigationUI.setupWithNavController(mBinding.btmNavi,navController)


    }
}