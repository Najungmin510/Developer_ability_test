package com.example.developer_ability_test.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.developer_ability_test.R
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.ViewModel.MainViewModel
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.code.btm_navigation
import com.example.developer_ability_test.databinding.FragmentTodoBinding
import com.example.developer_ability_test.dialog.CustomTodo
import com.example.developer_ability_test.recleAdapter.TODORecyclerAdapter

class TODO_fragment :Fragment(),View.OnClickListener{
    private var mBinding : FragmentTodoBinding?= null
    private lateinit var viewModel : MainViewModel
    private val TodoAdapter by lazy { TODORecyclerAdapter() }
    private val NavigationData = (activity as btm_navigation)
    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentTodoBinding.inflate(inflater, container, false)

        mBinding = binding
        mBinding!!.btnTodoAdd.setOnClickListener{ //할일 추가 버튼 클릭 시, 다이얼로그 띄워주기
            //그리고 다이얼 로그 내에서 post 진행해야함
            val customtodo = CustomTodo(NavigationData.Userid, object :CustomTodo.OnClickListener{ //유저 아이디 넘겨주기
                override fun onClick(dialog: CustomTodo) {

                }
            })

        }

        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){ //여기서 데이터 구해서 넘겨줘야함
        super.onViewCreated(view, savedInstanceState)

        var userid = NavigationData.LoginUserId() //parents에 있는 userid 가져오기
        Log.d("TodoFragmentLog : 유저 고유 번호",userid.toString())

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        viewModel.TodoDataLoginUsersResponse.observe(viewLifecycleOwner, Observer {
            viewModel.getLoginPosts(userid) //로그인한 사용자의 할일 리스트만 호출

            if(it.isSuccessful){
                TodoAdapter.setData(it.body()!!) //일단 데이터 넘겨주고, 리사이클러뷰에서 클릭작업
            } else{
                Log.d("TodoFragmentLog",it.code().toString())
            }
        })
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}


