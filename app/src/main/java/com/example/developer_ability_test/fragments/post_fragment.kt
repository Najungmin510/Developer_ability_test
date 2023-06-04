package com.example.developer_ability_test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.ViewModel.MainViewModel
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.code.btm_navigation
import com.example.developer_ability_test.databinding.FragmentPostBinding
import com.example.developer_ability_test.recleAdapter.PostRecyclerAdapter

class post_fragment :Fragment() {
    private lateinit var viewModel : MainViewModel
    private var mBinding : FragmentPostBinding?= null//member 변수 바인드
    private val NavigationData = (activity as btm_navigation) //중복되니까 그냥 여기다가 선언
    private val NoticeAdapter by lazy {PostRecyclerAdapter()}

    var Name = "" //로그인한 사용자의 이름
    var ID = 0 //로그인한 사용자의 고유 id
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentPostBinding.inflate(inflater, container, false)
        mBinding = binding
        Name = NavigationData.LoginUserName()
        ID = NavigationData.LoginUserId()

        Log.d("check",Name)
        Log.d("check",ID.toString()) //데이터 잘 넘어오는거 확인 완료

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){ //여기서 데이터 구해서 넘겨줘야함
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        viewModel.NoticeDataResponse.observe(viewLifecycleOwner, Observer{
            viewModel.getAllPosts()

            if(it.isSuccessful){
                NoticeAdapter.setData(it.body()!!) //일단 데이터 넘겨주기
            } else{
               Log.d("PostFragmentLog",it.code().toString())
            }
        })

        viewModel.getAllPosts()

    }
    private fun setupRecyclerView(){
        mBinding?.noticeRecyclerView?.adapter = NoticeAdapter
        mBinding?.noticeRecyclerView?.layoutManager = LinearLayoutManager(NavigationData)
    }

    override fun onDestroyView() {
        mBinding = null; //사용하지 않는다면 이 뷰 메모리 날려버리기
        super.onDestroyView()
    }
}
