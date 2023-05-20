package com.example.developer_ability_test.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.DialogFragment
import com.example.developer_ability_test.databinding.DialogNewTodoBinding
import com.example.developer_ability_test.retrofit_DTO.TodosItem

class CustomTodo : DialogFragment(){

    private var _binding : DialogNewTodoBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogNewTodoBinding.inflate(inflater, container, false)
        val view = binding.root

        var NP = "" //new todo post

        binding.btnNewTodoPost.setOnClickListener{ //버튼 클릭 시
            NP = binding.etNewTodo.toString()

            if(NP != ""){ //공백이 아니라면, 새로운 리스트 추가하기, 수정은 PUT, 이건 추가니까 POST
                uploadTodos(NP)
            }
            dismiss() //창 닫기
        }

        binding.btnNewTodoCancle.setOnClickListener{ //x버튼 클릭시
            dismiss()
        }
        return view
    }

    private fun uploadTodos(np: String) { //사용자가 입력한 새로운 할일을 추가 | 순서 =>  완료, 아이디(글순서), 내용, 유저아이디(사용자구분)
        val todo = TodosItem(false, 0, np, id)
    }


}