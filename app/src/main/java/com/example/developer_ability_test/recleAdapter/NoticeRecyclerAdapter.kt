package com.example.developer_ability_test.recleAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.developer_ability_test.R
import com.example.developer_ability_test.ViewModel.NoLogin_Notice_type
import com.example.developer_ability_test.code.Login_MainActivity
import com.example.developer_ability_test.databinding.CustomNoticeBinding
import com.example.developer_ability_test.retrofit_DTO.Posts
import com.example.developer_ability_test.retrofit_DTO.PostsItem
import com.example.developer_ability_test.retrofit_DTO.UsersItem

/*게시판 어댑터
제목, 작성자 이름, 댓글 수 (Listsize 리턴하면됨) , 내용, xml 두개 사용... 을 해야할듯??????????????
참고한게 R.layout 써서 헷갈릴까봐 똑같이 하긴 했는데, viewBinding으로 하는것에 익숙해지기 << 이게 더 효율적이고 편리함
* retrofit2 사용*/

class NoticeRecyclerAdapter(val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var List = emptyList<PostsItem>()

    lateinit var UserInform : Login_MainActivity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View?
        return when(viewType){
            NoLogin_Notice_type -> { //로그인 한 사용자가 작성한 글이 아니라면
                view = LayoutInflater.from(parent.context).inflate(R.layout.custom_notice,
                parent,
                false)
                NoticeRecyclerAdapter_no_Login(view)
            }

            else -> { // 로그인 한 사용자가 작성한 글이라면, xml변경 (구성은 똑같은데 이름만 다른거임, 클릭 시 수정 삭제 가능하게 하려고
                view = LayoutInflater.from(parent.context).inflate(R.layout.custom_notice_login,
                parent,
                false)
                NoticeRecyclerAdapter_Login(view)
            }
        }
    }

    override fun getItemCount(): Int { //리스트 크기
       return List.size
    }

    override fun getItemViewType(position: Int): Int {
        return List[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(List[position].type){
            NoLogin_Notice_type -> {
                (holder as NoticeRecyclerAdapter_no_Login).bind(List[position])

            }
        }
    }

    inner class NoticeRecyclerAdapter_no_Login(view : View) : RecyclerView.ViewHolder(view){

        fun bind(item: PostsItem) {

        }
    }

    inner class  NoticeRecyclerAdapter_Login(view : View) : RecyclerView.ViewHolder(view){

    }



}





