package com.example.iotteamproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.order_coffee.*

class CoffeeFragment: Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.order_coffee, container, false)
        return view
    }

    var testlist = ArrayList<test_recycle>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 1..10) {
            var test = test_recycle(R.drawable.coffee, "$i")
            testlist.add(test)
        }

        val adapter1 = context?.let { OrderRecyclerAdapter(it, R.layout.order_detail_menu,testlist) }
        val adapter2 = context?.let { OrderRecyclerAdapter(it, R.layout.order_detail_menu,testlist) }
        val adapter3 = context?.let { OrderRecyclerAdapter(it, R.layout.order_detail_menu,testlist) }

        val manager1 = LinearLayoutManager(context)
        manager1.orientation = LinearLayoutManager.HORIZONTAL
        fruit_recycler1.layoutManager = manager1

        val manager2 = LinearLayoutManager(context)
        manager2.orientation = LinearLayoutManager.HORIZONTAL
        fruit_recycler2.layoutManager = manager2

        val manager3 = LinearLayoutManager(context)
        manager3.orientation = LinearLayoutManager.HORIZONTAL
        fruit_recycler3.layoutManager = manager3

        fruit_recycler1.adapter = adapter1
        fruit_recycler2.adapter = adapter2
        fruit_recycler3.adapter = adapter3

        // 데이터 갱신 문제 : 다른 프래그먼트에서 작업한 후에 다시 되돌아왔을 때 데이터 갱신이 되지 않음
        // this 문제
        // https://furang-note.tistory.com/21
    }
}
