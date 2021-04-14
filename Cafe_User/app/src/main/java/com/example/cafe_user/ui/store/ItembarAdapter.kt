package com.example.cafe_user.ui.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.order_detail_menu.view.*
import kotlinx.android.synthetic.main.store_item.*

class ItembarAdapter(var context: Context, var itemLayout: Int, var datalist:ArrayList<>)
    : RecyclerView.Adapter<ItembarAdapter.itemViewHolder>() {


    inner class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val testImgView = itemView.test_img
        val testTextView = itemView.menu_test
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemLayout, null)
        val itemViewHolder = itemViewHolder(itemView)
        return itemViewHolder
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        var testImg = holder.testImgView
        var testText = holder.testTextView
        testImg.setImageResource(datalist.get(position).testImg)
        testText.setText(datalist.get(position).testText)
    }
}