package com.example.iotteamproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.order_detail_menu.view.*

class OrderRecyclerAdapter(var context: Context, var itemLayout: Int, var datalist:ArrayList<test_recycle>)
    :RecyclerView.Adapter<OrderRecyclerAdapter.OrderViewHolder>() {


    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val testImgView = itemView.test_img
        val testTextView = itemView.menu_test
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemLayout,null)
        val orderViewHolder = OrderViewHolder(itemView)
        return orderViewHolder
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        var testImg = holder.testImgView
        var testText = holder.testTextView
        testImg.setImageResource(datalist.get(position).testImg)
        testText.setText(datalist.get(position).testText)
    }
}