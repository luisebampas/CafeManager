package com.example.cafe_user.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.R
import com.example.cafe_user.ui.menu.menuitem
import com.example.iotteamproject.OrderRecyclerAdapter
import kotlinx.android.synthetic.main.order_smoothie.*

class SmoothieFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
            val view = inflater.inflate(R.layout.order_smoothie,container,false)
        return view
    }

    var datalist = ArrayList<menuitem>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datalist.add(menuitem(R.drawable.ic_launcher_background, "사과", "ame"
            , "마시쪙", 5000)
        )

        datalist.add(menuitem(R.drawable.ic_launcher_background, "파인애플", "latte"
            , "호", 6000))

        datalist.add(menuitem(R.drawable.ic_launcher_background, "자두", "moca"
            , "하", 7000))

        val adapter1 = context?.let { OrderRecyclerAdapter(it, R.layout.cardviewitem,datalist) }
        val adapter2 = context?.let { OrderRecyclerAdapter(it, R.layout.cardviewitem,datalist) }
        val adapter3 = context?.let { OrderRecyclerAdapter(it, R.layout.cardviewitem,datalist) }

        val manager1 = LinearLayoutManager(context)
        manager1.orientation = LinearLayoutManager.HORIZONTAL
        smoothie_recycler1.layoutManager = manager1

        val manager2 = LinearLayoutManager(context)
        manager2.orientation = LinearLayoutManager.HORIZONTAL
        smoothie_recycler2.layoutManager = manager2

        val manager3 = LinearLayoutManager(context)
        manager3.orientation = LinearLayoutManager.HORIZONTAL
        smoothie_recycler3.layoutManager = manager3

        smoothie_recycler1.adapter = adapter1
        smoothie_recycler2.adapter = adapter2
        smoothie_recycler3.adapter = adapter3
    }
}