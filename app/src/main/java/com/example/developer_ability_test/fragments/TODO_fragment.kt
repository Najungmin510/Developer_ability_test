package com.example.developer_ability_test.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.developer_ability_test.databinding.FragmentTodoBinding
import com.example.developer_ability_test.dialog.CustomTodo

class TODO_fragment :Fragment(), View.OnClickListener{
    private var mBinding : FragmentTodoBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTodoBinding.inflate(inflater, container, false)
        mBinding = binding


        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    override fun onClick(p0: View?) {

    }


}


