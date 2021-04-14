package com.example.cafe_user.ui.menu

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.R
import com.example.cafe_user.ui.cart.CartFragment
import com.example.cafe_user.ui.cart.CartItems
import kotlinx.android.synthetic.main.cardviewitem.*
import kotlinx.android.synthetic.main.menu_detail.*
import java.io.ByteArrayOutputStream

class MenuDetail : AppCompatActivity() {
    var datalist = ArrayList<menuitem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_detail)

        datalist.add(menuitem(R.drawable.ic_launcher_background, "아메리카노", "ame", "마시쪙", 5000))

        datalist.add(menuitem(R.drawable.ic_launcher_background, "카페라떼", "latte", "호", 6000))

        datalist.add(menuitem(R.drawable.ic_launcher_background, "카페모카", "moca", "하", 7000))

        val card_adapter = menuadapter(this, R.layout.cardviewitem, datalist)
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        menu_recycler.layoutManager = manager
        menu_recycler.adapter = card_adapter

        var size: RadioGroup = findViewById(R.id.size_group)
        var checksize: RadioButton = findViewById(size.checkedRadioButtonId)
        var sizevalue = checksize.text.toString()

        var temp: RadioGroup = findViewById(R.id.temp_group)
        var checktemp: RadioButton = findViewById(temp.checkedRadioButtonId)
        var tempvalue = checktemp.text.toString()

        val bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.coffee)
        val stream = ByteArrayOutputStream()
        bitmap.compress(CompressFormat.JPEG, 100, stream)
        val byteArray = stream.toByteArray()

        btn_add_cart.setOnClickListener {
            val menu_data = Intent(this, CartItems::class.java).apply {
                putExtra("image", byteArray)
                putExtra("temp", tempvalue)
                putExtra("size", sizevalue)
                putExtra("price", price.text.toString().toInt())
            }
            startActivity(menu_data)
        }
    }
}
