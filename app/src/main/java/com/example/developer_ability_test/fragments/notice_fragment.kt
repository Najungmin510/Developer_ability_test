package com.example.developer_ability_test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.developer_ability_test.databinding.FragmentNoticeBinding

class notice_fragment :Fragment() {

    private var mBinding : FragmentNoticeBinding?= null//member 변수 바인딩




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNoticeBinding.inflate(inflater, container, false)
        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null; //사용하지 않는다면 이 뷰 메모리 날려버리기
        super.onDestroyView()
    }
}