package com.example.developer_ability_test.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.developer_ability_test.Repository.Repository
import com.example.developer_ability_test.retrofit_DTO.PostsItem
import com.example.developer_ability_test.retrofit_DTO.TodosItem
import com.example.developer_ability_test.retrofit_DTO.UsersItem
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repository) : ViewModel() {

    val LoginUserResponse : MutableLiveData<Response<List<UsersItem>>> = MutableLiveData() //로그인한 사용자 정보

    val NoticeDataResponse : MutableLiveData<Response<List<PostsItem>>> = MutableLiveData() //전체 게시글

    val NoticeDataLoginUserResponse : MutableLiveData<Response<List<PostsItem>>> = MutableLiveData() //로그인 유저의 게시글

    val TodoDataLoginUsersResponse : MutableLiveData<Response<List<TodosItem>>> = MutableLiveData() //로그인 유저의 todolist

    fun getLogin(name : String){ //로그인 정보 가져오기
        viewModelScope.launch {
            val response = repository.getLogin(name)
            LoginUserResponse.value = response
        }
    }

    fun getLoginPosts(id : Int){ //로그인한 유저의 게시글 가져오기
        viewModelScope.launch {
            val response = repository.getLoginPosts(id)
            NoticeDataLoginUserResponse.value = response
        }
    }

    fun getLoginTodos(id : Int){ //로그인한 유저의 할일 리스트 가져오기
        viewModelScope.launch {
            val response = repository.getLoginTodos(id)
            TodoDataLoginUsersResponse.value = response
        }
    }

}