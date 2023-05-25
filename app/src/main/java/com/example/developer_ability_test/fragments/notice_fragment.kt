package com.example.developer_ability_test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.developer_ability_test.databinding.FragmentNoticeBinding
import com.example.developer_ability_test.recleAdapter.NoticeRecyclerAdapter

class notice_fragment :Fragment() {

    /* 데이터 가져와서 프레그 먼트에서 파싱하는게 아니라 어댑터에서 해야할듯????? */

    private var mBinding : FragmentNoticeBinding?= null//member 변수 바인드
    private val noticeAdapter = NoticeRecyclerAdapter() //어댑터 연결

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentNoticeBinding.inflate(inflater, container, false)
        mBinding = binding

        var loginUser = arguments?.getString("login")
        var loginId = arguments?.getInt("id") //로그인 한 사용자 정보 가져오기

        //레이아웃 매니저 & 어댑터
        mBinding!!.noticeRecyclerView.layoutManager = LinearLayoutManager(context)
        mBinding!!.noticeRecyclerView.adapter = noticeAdapter
        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null; //사용하지 않는다면 이 뷰 메모리 날려버리기
        super.onDestroyView()
    }
}