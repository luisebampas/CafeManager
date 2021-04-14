package com.example.cafe_user.ui.menu

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.testlayout.*

class IntentTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testlayout)
        val data = intent
        val name = data.getStringExtra("kor_name")
        val price = data.getIntExtra("price", 0)
        val temp = data.getStringExtra("temp")
        val size = data.getStringExtra("size")

        textView3.text = name
        textView4.text = price.toString()
        textView5.text = temp
        textView6.text = size
        val byteArray = data.getByteArrayExtra("image")
        val image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        val ivImage : ImageView = findViewById(R.id.imageView)
        ivImage.setImageBitmap(image)
    }
}