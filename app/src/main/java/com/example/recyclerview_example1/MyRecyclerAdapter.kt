package com.example.recyclerview_example1

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(myRecyclerviewInterface: MyRecyclerviewInterface): RecyclerView.Adapter<MyViewHolder>(){

    private var modelList = ArrayList<MyModel>()

    private var myRecyclerviewInterface : MyRecyclerviewInterface? =null

    //생성자
    init {
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }

    //뷰홀더 생성 되었을때, !!->꼭 값이 있다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item,parent,false),this.myRecyclerviewInterface!!)
    }

    //item갯수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    //뷰와 뷰 홀더가 묶였을때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position : $position")
        holder.bind(this.modelList[position])


    }

    fun submitList (modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }

}