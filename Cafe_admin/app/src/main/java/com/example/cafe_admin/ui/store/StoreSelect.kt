package com.example.cafe_admin.ui.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cafe_admin.R
import com.example.cafe_user.ui.store.MainFragment
import com.example.cafe_user.ui.store.StoreData

var MainView: MainFragment? = null
var BeanView: BeanFragment? = null
var FruitView: FruitFragment? = null
var DairyView: DiaryFragment? = null
var DesertView: DessertFragment? = null
var MarcaronView: MarcaronFragment? = null

class StoreSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_select)

        MainView = MainFragment()
        BeanView = BeanFragment()
        FruitView = FruitFragment()
        DairyView = DiaryFragment()
        DesertView = DessertFragment()
        MarcaronView = MarcaronFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.store_tab_fragment, MainView!!)

    }
    fun category_click(view: View) {
        setFragment(view.getTag().toString())
    }
    fun setFragment(tag:String) {
        var tab_manager = supportFragmentManager
        var transaction = tab_manager.beginTransaction()
        when (tag) {
            "1" -> transaction.replace(R.id.store_tab_fragment,BeanView!!)
            "2" -> transaction.replace(R.id.store_tab_fragment,FruitView!!)
            "3" -> transaction.replace(R.id.store_tab_fragment,DairyView!!)
            "4" -> transaction.replace(R.id.store_tab_fragment,DesertView!!)
            "5" -> transaction.replace(R.id.store_tab_fragment,MarcaronView!!)
        }
        transaction.commit()
    }



}