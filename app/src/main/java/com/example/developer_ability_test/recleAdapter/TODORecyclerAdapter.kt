package com.example.developer_ability_test.recleAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.developer_ability_test.databinding.CustomTodoBinding
import com.example.developer_ability_test.retrofit_DTO.TodosItem

class TODORecyclerAdapter : RecyclerView.Adapter<TODORecyclerAdapter.TodoViewHolder>(){

    private var TodoList = emptyList<TodosItem>()

    class TodoViewHolder(val binding : CustomTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = CustomTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.todoTitle.text = TodoList[position].title
    }

    override fun getItemCount(): Int {
        return TodoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList : List<TodosItem>){
        TodoList = newList
        notifyDataSetChanged()
    }
}