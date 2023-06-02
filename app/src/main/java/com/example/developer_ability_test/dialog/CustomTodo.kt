package com.example.developer_ability_test.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.EditText
import com.example.developer_ability_test.R
import com.example.developer_ability_test.databinding.CustomTodoBinding
import com.example.developer_ability_test.databinding.DialogNewTodoBinding
import com.example.developer_ability_test.retrofit_DTO.TodosItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomTodo( private val userid : Int, private val listener : OnClickListener) : BottomSheetDialogFragment(),
View.OnClickListener{

    private lateinit var binding: CustomTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = CustomTodoBinding.inflate(layoutInflater)
        val newList = binding.todoTitle.toString() //사용자가 입력한 할일 가져와서

        uploadTodos(newList) //Post

        return inflater.inflate(R.layout.custom_todo, container, false)
    }

    private fun uploadTodos(np: String) { //사용자가 입력한 새로운 할일을 추가 | 순서 =>  완료, 아이디(글순서), 내용, 유저아이디(사용자구분)
        TodosItem(false, userid, np, id) //순서대로 완료여부, 고유아이디, 작성내용,
    }

    interface OnClickListener{
        fun onClick(dialog : CustomTodo)
    }
    override fun onClick(p0: View?) {
        listener.onClick(this)
    }


}


