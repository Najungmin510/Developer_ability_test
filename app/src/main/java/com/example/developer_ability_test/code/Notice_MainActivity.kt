package com.example.developer_ability_test.code

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.IntentCompat.getParcelableExtra
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.ActivityNoticeMainBinding
import com.example.developer_ability_test.retrofit_login.Login_Success_User


/*로그인 한 사용자의 객체를 로그인 activity에서 받아와서, 로그인 한 사용자의 id == 게시글의 userid 일치하나 확인
일치 한다면, 자신이라는 것을 알려주어야 함.
삭제, 수정 기능 추가.*/

/*getParcelableExtra관련 이슈 해결 ▽
* https://velog.io/@jeep_chief_14/getParcelableExtra-getSerializable-is-deprecated-in-Android-13*/


class Notice_MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeMainBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_main)
        binding = ActivityNoticeMainBinding.inflate(layoutInflater)
        val view = binding.root

        val intent : Intent = intent
        val Logindata = intent.getParcelableExtra<Login_Success_User>("LoginUser", Login_Success_User::class.java)


        if (Logindata != null) {
            binding.testName.text = Logindata.Success_user_name //값이 잘 가져와지나 테스트 할거임
            binding.testId.text = Logindata.Success_user_id.toString()
        } else{
            Toast.makeText(this,"실패", Toast.LENGTH_SHORT).show()
        }


    }
}