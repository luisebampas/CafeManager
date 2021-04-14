package com.example.cafe_user.ui.cart


import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.activity_cart.*
import androidx.appcompat.app.AppCompatActivity
import com.example.cafe_user.ui.payment.Payment
import com.example.fragment.recycler.SwipeListAdapter


class CartFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var datalist = ArrayList<CartItems>()

        // MenuDetail에서 직접 받은 data
        var data = intent
        val name = data.getStringExtra("kor_name")
        val temp = data.getStringExtra("temp")
        val size = data.getStringExtra("size")


        // 임시 data
        datalist.add(CartItems(R.drawable.ic_launcher_background, "아메리카노", "ame", "hot", 1, 5000))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "카페라뗴", "latte", "ice", 2, 5500))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "초코라떼", "choco", "ice", 1, 5500))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "딸기쥬스", "strawberry", "ice", 1, 6500))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "블루베리스무디", "blueberry", "ice", 1, 6500))


        val cart_adapter = SwipeListAdapter(this, R.layout.item_swipe, datalist)
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        cart_recycler.layoutManager = manager
        cart_recycler.adapter = cart_adapter



        // 결제정보 Payment로 넘기는 intent
        btn_payment.setOnClickListener {
            val cart_items = Intent(this, Payment::class.java).apply {
                putExtra("table_no", 1)
                putExtra("price", total_txt.text.toString().toInt())
            }
            startActivity(cart_items)
        }
    }
}

