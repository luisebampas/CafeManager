package com.example.iotteamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cafe_user.R

class OrderActivity : AppCompatActivity() {
    var CoffeeView:CoffeeFragment? = null
    var JuiceView:JuiceFragment? = null
    var SmoothieView:SmoothieFragment? = null
    var BreadView:BreadFragment? = null
    var DessertView:DessertFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_screen)

        CoffeeView = CoffeeFragment()
        JuiceView = JuiceFragment()
        SmoothieView = SmoothieFragment()
        BreadView = BreadFragment()
        DessertView = DessertFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.order_menu_fragment,CoffeeView!!)

    }
    fun category_click(view: View) {
        setFragment(view.getTag().toString())
    }
    fun setFragment(tag:String) {
        var category_manager = supportFragmentManager
        var transaction = category_manager.beginTransaction()
        when (tag) {
            "1" -> transaction.replace(R.id.order_menu_fragment,CoffeeView!!)
            "2" -> transaction.replace(R.id.order_menu_fragment,JuiceView!!)
            "3" -> transaction.replace(R.id.order_menu_fragment,SmoothieView!!)
            "4" -> transaction.replace(R.id.order_menu_fragment,BreadView!!)
            "5" -> transaction.replace(R.id.order_menu_fragment,DessertView!!)
        }
        transaction.commit()
    }


}