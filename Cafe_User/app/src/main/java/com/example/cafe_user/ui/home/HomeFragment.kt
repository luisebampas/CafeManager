package com.example.cafe_user.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.MainActivity
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.main_card_recycle_menu.*

class HomeFragment : Fragment() {
    var main_menulist = ArrayList<MenuRecycleItem>()

    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.main_card_recycle_menu, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //xml정의된 id명으로 접근해서 사용하
        //main_menulist 목록 넣기
        main_menulist.add(MenuRecycleItem(R.drawable.main_coffee,"Coffee & Beverages"))
        main_menulist.add(MenuRecycleItem(R.drawable.main_bread,"Bread & Cake"))
        main_menulist.add(MenuRecycleItem(R.drawable.main_des,"Desert"))

        val myadapter = RecyclerCardAdapter(activity as MainActivity , R.layout.main_card_view_menu, main_menulist)
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_card.layoutManager = manager
        recycler_card.adapter = myadapter

    }
}