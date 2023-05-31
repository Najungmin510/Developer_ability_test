package com.example.developer_ability_test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.developer_ability_test.InterfaceFile.RetrofitService
import com.example.developer_ability_test.R
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.Retrofit2.RetrofitInstance
import com.example.developer_ability_test.ViewModel.MainViewModel
import com.example.developer_ability_test.ViewModel.MainViewModelFactory
import com.example.developer_ability_test.code.btm_navigation
import com.example.developer_ability_test.databinding.FragmentNoticeBinding
import com.example.developer_ability_test.recleAdapter.NoticeRecyclerAdapter
import com.example.developer_ability_test.retrofit_DTO.Posts
import retrofit2.Response

class notice_fragment :Fragment() {
    private lateinit var viewModel : MainViewModel
    private var mBinding : FragmentNoticeBinding?= null//member 변수 바인드
    private val NavigationData = (activity as btm_navigation) //중복되니까 전역변수로 해줌
    private val NoticeAdapter by lazy {NoticeRecyclerAdapter()}

    var Name = "" //로그인한 사용자의 이름
    var ID = 0 //로그인한 사용자의 고유 id
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentNoticeBinding.inflate(inflater, container, false)
        mBinding = binding
        Name = NavigationData.LoginUserName()
        ID = NavigationData.LoginUserId()

        //Log.d("check",Name)
        //Log.d("check",ID.toString()) //데이터 잘 넘어오는거 확인 완료

        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){ //여기서 데이터 구해서 넘겨줘야함
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.NoticeDataResponse.observe(viewLifecycleOwner, Observer {
            viewModel.getAllPosts()

            if(it.isSuccessful){
                NoticeAdapter.setData(it.body()!!) //일단 데이터 넘겨주기
            } else{
               Log.d("NoticeFragmentLog",it.code().toString())
            }
        })
    }

    override fun onDestroyView() {
        mBinding = null; //사용하지 않는다면 이 뷰 메모리 날려버리기
        super.onDestroyView()
    }

}