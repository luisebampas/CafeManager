package com.example.cafe_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.drawer.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer)

        open.setOnClickListener {
            if (!drawer.isDrawerOpen(Gravity.RIGHT)){
                drawer.openDrawer(Gravity.RIGHT)
            }
        }

        close.setOnClickListener {
            if (drawer.isDrawerOpen(Gravity.RIGHT)){
                drawer.closeDrawer(Gravity.RIGHT)
            }
        }
    }
}