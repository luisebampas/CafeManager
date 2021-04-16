package com.example.cafe_user.ui.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.store_item.*
import java.text.SimpleDateFormat

class ItembarAdapter(var context: Context, var itemLayout: Int, var datalist:ArrayList<>)
    : RecyclerView.Adapter<ItembarAdapter.itemViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        // 아이템 레이아웃을 클래스로 변환해 홀더로 만든다.
        val itemView = LayoutInflater.from(context).inflate(itemLayout, null)
        val itemViewHolder = itemViewHolder(itemView)
        return itemViewHolder
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
    // 실제로 생성된 뷰에 넣을 값을 미리 setting 하는 역할.
    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        var testImg = holder.testImgView
        var testText = holder.testTextView
        testImg.setImageResource(datalist.get(position).testImg)
        testText.setText(datalist.get(position).testText)
    }

    // 아이템뷰에 정리한 데이터를 기입하는 홀더. 각각의 뷰에 기능을 넣으려면 이 클래스 안에 정의할 것.
    inner class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val testImgView = itemView.test_img
        val testTextView = itemView.menu_test

//        fun setData(storedata:StoreData){
//            itemView.XML뷰의 이름.text = "${storedata.no}"
//
//            val sdf = SimpleDateFormat("yyyy/MM/dd")
//            val date = sdf.format(storedata.timestamp)
//            itemView.textDate.text = data
//        }




    }
}