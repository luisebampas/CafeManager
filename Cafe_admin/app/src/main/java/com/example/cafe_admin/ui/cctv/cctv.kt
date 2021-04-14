package com.example.selftest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.cafe_admin.R
import kotlinx.android.synthetic.main.cctv.*
import java.text.SimpleDateFormat
import java.util.*


class cctv : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cctv)

        val current = Calendar.getInstance().time
        var Format = SimpleDateFormat("yyyy.MM.dd  ", Locale.KOREA).format(current)

        date_text.text = Format
        cctv_view.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }

        cctv_view.loadUrl("http://172.30.1.54:5000/on")
    }
}