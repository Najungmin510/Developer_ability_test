package com.example.developer_ability_test.InterfaceFile

import com.example.developer_ability_test.retrofit_DTO.Posts
import com.example.developer_ability_test.retrofit_DTO.PostsItem
import com.example.developer_ability_test.retrofit_DTO.TodosItem
import com.example.developer_ability_test.retrofit_DTO.Users
import com.example.developer_ability_test.retrofit_DTO.UsersItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("/users")
    suspend fun getUsers(
        @Query("name") name : String
    ) : Response<List<UsersItem>>

    @GET("/posts")
    suspend fun getAllPosts() : Response<List<PostsItem>>//게시글 데이터 다 가져오기

    @GET("/posts")
    suspend fun getLoginPosts( //로그인 한 사용자의 userid는 따로 가져와주기(삭제, 수정 기능때문에)
        @Query("userid") userId : Int
    ) : Response<List<PostsItem>>

    @GET("/todos")
    suspend fun getLoginTodos( //자신이 작성한 리스트만 가져오기
        @Query("id") userId: Int
    ) : Response<List<TodosItem>>

    /*notice, todos 어차피 로그인 하면서 사용자 이름, id 저장해서 넘길거라서 경로로 해도 무관
    둘 다 userid로 구분되기 때문, username은 혹시 몰라서 데이터 받아둔거임 쓸 곳 있을까봐
    */

    /*
    @POST("/posts")
    suspend fun uploadPosts(@Body Posts : PostsItem) : Response<PostsItem>

    @POST("/todos")
    suspend fun uploadTodos(@Body Todos : TodosItem) : Response<TodosItem>
*/
}