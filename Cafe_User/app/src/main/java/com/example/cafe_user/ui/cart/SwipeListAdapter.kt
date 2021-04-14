package com.example.fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe_user.ui.cart.CartItems
import kotlinx.android.synthetic.main.item_swipe.view.*



class SwipeListAdapter (var context : Context, var itemlayout : Int, var datalist : ArrayList<CartItems>)
    : RecyclerView.Adapter<SwipeListAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        var cart_img = itemview.cart_image
        var menu_kor_name = itemview.item_kor
        var menu_eng_name = itemview.item_eng
        var item_size = itemview.item_size
        var item_count = itemview.item_count
        var item_price = itemview.item_price

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemlayout, null)
        val myViewholder = MyViewHolder(itemView)
        return myViewholder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var cart_img = holder.cart_img
        cart_img.setImageResource(datalist[position].cart_img!!)

        var kor = holder.menu_kor_name
        kor.text = datalist[position].kor_title!!

        var eng = holder.menu_eng_name
        eng.text = datalist[position].eng_title!!

        var size = holder.item_size
        size.text = datalist[position].cart_item_size!!

        var count = holder.item_count
        count.text = datalist[position].cart_item_count.toString()!!

        var price = holder.item_price
        price.text = datalist[position].cart_item_price.toString()!!
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}