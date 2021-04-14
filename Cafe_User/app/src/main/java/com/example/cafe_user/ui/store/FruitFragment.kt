package com.example.cafe_user.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cafe_user.R

class FruitFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
            val view = inflater.inflate(R.layout.order_smoothie,container,false)
        return view
    }
}