package com.example.recyclerview_example1

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_recycler_item.view.*

//커스텀
class MyViewHolder(itemView: View,
                   myRecyclerviewInterface: MyRecyclerviewInterface):
                    RecyclerView.ViewHolder(itemView),
                    View.OnClickListener

{


    val TAG: String = "로그"

    private val usernameTextView = itemView.user_name_txt
    private val profileImageView = itemView.profile_img

    private var myRecyclerviewInterface : MyRecyclerviewInterface? = null

    init {
        Log.d(TAG, "MyViewHolder - init() called")


        itemView.setOnClickListener(this)
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }

    //데이터와 뷰를 묶는다.
    fun bind(myModel: MyModel){
        Log.d(TAG, "MyViewHolder - bind() called")
        usernameTextView.text = myModel.name

        Glide
            .with(App.instance)
            .load(myModel.profileImage)
//            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(profileImageView);
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "MyViewHolder - onClick() called")
        this.myRecyclerviewInterface?.onItemClicked()
    }


}