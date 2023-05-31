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
*/

class NoticeRecyclerAdapter : RecyclerView.Adapter<NoticeRecyclerAdapter.PostViewHolder>() {
    private var List = emptyList<PostsItem>()
    class PostViewHolder(val binding: CustomNoticeBinding) : RecyclerView.ViewHolder(binding.root)

    //새로운 뷰 홀더를 생성할 xml 지정 (재사용할 뷰가 없을 때 생성됨)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CustomNoticeBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PostViewHolder(binding)
    }

    //뷰 홀더에 데이터 바인딩 해주기, contents를 바꿔주는 메서드
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) { //데이터 지정
        holder.binding.noticeTitle.text = List[position].title //제목
        holder.binding.noticeContent.text = List[position].body //내용
        holder.binding.noticeWriter.text =

    }


    //뷰 홀더 개수 리턴
    override fun getItemCount(): Int {
        return List.size
    }

    //데이터 변겅 or 추가 시에 리스트 재할당(새로고침)
    @SuppressLint("NotifyDataSetChanged")
    fun setData(body : List<PostsItem>){
        List = body
        notifyDataSetChanged()
    }

    //index == id, 유저는 총 10명, 처음 인덱스 0이라서 그냥 NoUser라고 값 줌
    fun userName(args:Array<String>){
        var UserName = arrayOf("NoUser","Bret", "Antonette","Samantha","Karianne","Kamren",
        "Leopoldo_Corkery", "Elwyn.Skiles", "Maxime_Nienow", "Delphine", "Moriah.Stanton")
    }

}





