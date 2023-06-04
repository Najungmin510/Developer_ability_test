package com.example.developer_ability_test.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.developer_ability_test.BaseUrl.TODO_USERID_DATA
import com.example.developer_ability_test.R
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.ViewModel.MainViewModel
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.databinding.DialogNewTodoBinding
import com.example.developer_ability_test.retrofit_DTO.TodosItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CustomTodoDialog() : BottomSheetDialogFragment(),
View.OnClickListener{

    private lateinit var binding: DialogNewTodoBinding
    private lateinit var viewModel : MainViewModel
    var userid = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogNewTodoBinding.inflate(layoutInflater)
        val view : View = inflater.inflate(R.layout.dialog_new_todo, container, false)

        val bundle = arguments
        userid = bundle?.getInt(TODO_USERID_DATA)!! //부모 프래그먼트에서 보내온 bundle data 값을 저장해줌

        val newList = binding.etNewTodo.toString()
        val sendData = binding.btnNewTodoPost
        val cancleData = binding.btnNewTodoCancle

        sendData.setOnClickListener{
            if(newList != ""){
                upLoad(newList) //업로드 해주기 (post)
                dismiss() //업로드 후 종료
            } else {
                Log.d("CustomtodoDialog : ", "비어있음")
            }
        }

        cancleData.setOnClickListener { //닫기 버튼 클릭시 종료
            dismiss()
        }

        return view
    }

    private fun upLoad(Data: String) { //사용자가 입력한 새로운 할일을 추가 | 순서 =>  완료, 아이디(글순서), 내용, 유저아이디(사용자구분)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val NewTodo = TodosItem(false,0, Data, userid) //id는 서버에서 따로 추가하는 것이기 때문에 유저고유 아이디만 작성해주면됨
        viewModel.uploadTodos(NewTodo) //데이터 추가

        viewModel.TodoDataUploadResponse.observe(this, Observer {
            if(it.isSuccessful){
                Log.d("Customtodo test", it.body().toString())
                Log.d("Customtodo test", it.code().toString())

            } else{
                Log.d("Customtodo test", it.body().toString())
                Log.d("Customtodo test", it.code().toString())

            }
        }) //viewmodel
    }

    fun getInstance() : CustomTodoDialog {
        return CustomTodoDialog()
    }

    override fun onClick(p0: View?) {
        dismiss()
    }

}


