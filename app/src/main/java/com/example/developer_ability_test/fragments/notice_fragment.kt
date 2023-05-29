package com.example.developer_ability_test.fragments

import android.os.Bundle
import android.util.Log
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
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.Retrofit2.RetrofitInstance
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.code.Login_MainActivity
import com.example.developer_ability_test.code.btm_navigation
import com.example.developer_ability_test.databinding.FragmentNoticeBinding
import com.example.developer_ability_test.retrofit_DTO.Posts
import retrofit2.Response

class notice_fragment :Fragment() {

    private var mBinding : FragmentNoticeBinding?= null//member 변수 바인드

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentNoticeBinding.inflate(inflater, container, false)
        mBinding = binding
        val a = (activity as btm_navigation).redata()
        Log.d("check",a)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){ //여기서 데이터 구해서 넘겨줘야함
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        mBinding = null; //사용하지 않는다면 이 뷰 메모리 날려버리기
        super.onDestroyView()
    }



}