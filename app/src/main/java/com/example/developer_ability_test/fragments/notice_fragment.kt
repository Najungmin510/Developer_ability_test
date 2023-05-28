package com.example.developer_ability_test.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.developer_ability_test.InterfaceFile.RetrofitService
import com.example.developer_ability_test.R
import com.example.developer_ability_test.Retrofit2.RetrofitInstance
import com.example.developer_ability_test.code.Login_MainActivity
import com.example.developer_ability_test.databinding.FragmentNoticeBinding
import com.example.developer_ability_test.retrofit_DTO.Posts
import retrofit2.Response

class notice_fragment :Fragment() {

    private var mBinding : FragmentNoticeBinding?= null//member 변수 바인드
    //private val noticeAdapter = NoticeRecyclerAdapter() //어댑터 연결

    //lateinit var UserInform : Login_MainActivity //Context를 할당할 변수, 프로퍼티로 선언

    //override fun onAttach(context : Context){ /*fragment <-> activtiy*/
        //super.onAttach(context)
       //UserInform = context as Login_MainActivity //액티비티로 형변환 해서 할당
    //}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentNoticeBinding.inflate(inflater, container, false)
        mBinding = binding

        //레이아웃 매니저 & 어댑터
        //mBinding!!.noticeRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        //mBinding!!.noticeRecyclerView.adapter = noticeAdapter


        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null; //사용하지 않는다면 이 뷰 메모리 날려버리기
        super.onDestroyView()
    }
/*
    override fun onStart(){ //context 관련 코드
        super.onStart()

        //val UserName = UserInform.findViewById<EditText>(R.id.etUserId).text.toString()

    }
    */
}