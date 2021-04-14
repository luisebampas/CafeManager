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
}