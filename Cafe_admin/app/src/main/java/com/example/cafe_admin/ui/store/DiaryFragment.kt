package com.example.cafe_user.ui.store

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.store_item.*

class DiaryFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.order_bread,container,false)
            progressBar.max = 50

            val currentProgress = 40

            ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                .setDuration(2000)
                .start()
        return view
    }

    // 1. data 로딩
    val data = loadData()
    // 2, 어댑터 생성
    val adapter = CustomAdpater()
    // 3. 어댑터에 데이터 전달
    recycler.listData = data
    // 4. 화면에 있는 리싸이클러뷰에 아답터 연결
    recycler.adapter = adapter
    // 5. 레이아웃 매니저 연결 - 각각의 뷰들을 담을 레이아웃 설정.
    recyceler.layoutManager = LinearLayoutManager(this)


    fun loadData() : MutableList<StoreData>{
        val data : MutableList<StoreData> = mutableListOf()
        for (no in 1..100){
            val title = "${no}"

        }
    }

}

