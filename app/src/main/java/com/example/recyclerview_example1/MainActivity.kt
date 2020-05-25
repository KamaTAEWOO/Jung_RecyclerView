package com.example.recyclerview_example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyRecyclerviewInterface {

    val TAG: String = "로그"

    //데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        for(i in 1..10){
            val MyModel = MyModel(name ="쩡대리 $i", profileImage = "https://img1.daumcdn.net/thumb/C100x100.mplusfriend/?fname=http%3A%2F%2Fk.kakaocdn.net%2Fdn%2FIxxPp%2FbtqC9MkM3oH%2FPpvHOkfOiOpKUwvvWcxhJ0%2Fimg_s.jpg")
            this.modelList.add(MyModel)

        }
        Log.d(TAG, "MainActivity - 반복문 돌린 후 this.modelList.size: ${this.modelList.size}")

        //어답터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter(this)

        myRecyclerAdapter.submitList(this.modelList)

        //리사이클러뷰 설정
        my_recycler_view.apply {

            //방향 설정 등등
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

            //어답터 장착
            adapter=myRecyclerAdapter

        }

    }

    override fun onItemClicked() {
        Log.d(TAG, "MainActivity - onItemClicked() called")
    }
}
