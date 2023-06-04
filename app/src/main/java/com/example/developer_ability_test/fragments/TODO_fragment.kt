package com.example.developer_ability_test.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.developer_ability_test.BaseUrl.TODO_ADD_EVENT
import com.example.developer_ability_test.BaseUrl.TODO_USERID_DATA
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.ViewModel.MainViewModel
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.code.btm_navigation
import com.example.developer_ability_test.databinding.FragmentTodoBinding
import com.example.developer_ability_test.dialog.CustomTodoDialog
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

        /*btm다이얼로그 띄울 부모 프래그먼트*/

        /*bundle이용해서 프래그먼트끼리
           데이터 공유, intent와 똑같이 tag가 있어야 데이터 받을 수 있기 때문에 아래처럼 코드짬
           tag 둘로 나눈건 데이터 받는 용도 , 호출하는 용도 두가지로 구분하려고
           TODO_DATA는 상수로 BaseUrl -> Constants.kt에 선언해둠 편하게 쓰려고*/

        mBinding!!.btnTodoAdd.setOnClickListener {  //추가하기 버튼 클릭시
            val bundle = Bundle()
            val sendData = NavigationData.Userid

            bundle.putInt(TODO_USERID_DATA, sendData) //고유아이디 bundle로 전송

            val dialog : CustomTodoDialog = CustomTodoDialog().getInstance() //로그인 한 사용자 고유아이디 넘겨주기
            dialog.arguments = bundle
            activity?.supportFragmentManager?.let { 
                fragmentManager -> dialog.show(fragmentManager, TODO_ADD_EVENT)
            }
        }
        return mBinding?.root

    }

    //서버에 저장되어 있는 데이터 받아오기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){ //여기서 데이터 구해서 넘겨줘야함
        super.onViewCreated(view, savedInstanceState)

        val userid = NavigationData.LoginUserId() //parents에 있는 userid 가져오기
        //Log.d("TodoFragmentLog : 유저 고유 번호",userid.toString())

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        viewModel.TodoDataLoginUsersResponse.observe(viewLifecycleOwner, Observer {
            viewModel.getLoginPosts(userid) //로그인한 사용자의 할일 리스트만 호출

            if(it.isSuccessful){
                TodoAdapter.setData(it.body()!!) //일단 데이터 넘겨주고, 수정하는건 리사이클러뷰에서 클릭작업

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
