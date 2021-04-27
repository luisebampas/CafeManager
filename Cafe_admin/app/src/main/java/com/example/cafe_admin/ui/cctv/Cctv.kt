package com.example.cafe_admin.ui.cctv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_admin.MainActivity
import com.example.cafe_admin.R
import com.example.cafe_admin.ui.environment.EnvironMqtt
import kotlinx.android.synthetic.main.cctv.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class Cctv : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.cctv, container, false)

        return view

    }
    lateinit var mqttClient:EnvironMqtt

    var led01_flag:Int = 0
    var led02_flag:Int = 0
    var led03_flag:Int = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val current = Calendar.getInstance().time
        var Format = SimpleDateFormat("yyyy.MM.dd  ", Locale.KOREA).format(current)

        date_text.text = Format
        cctv_view.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
        cctv_view.loadUrl("http://192.168.0.214:5000/show")

        mqttClient = EnvironMqtt(activity as MainActivity, "tcp://192.168.0.212:1883")

        try{
            mqttClient.connect(arrayOf<String>("admin/#"))
        }catch (e: Exception){
            e.printStackTrace()
        }

        admin_led01.setOnClickListener{
            if(led01_flag==0){
                publish("LED01_ON")
                led01_flag=1
            }
            else{
                publish("LED01_OFF")
                led01_flag=0
            }

        }
        admin_led02.setOnClickListener{
            if(led02_flag==0){
                publish("LED02_ON")
                led02_flag=1
            }
            else{
                publish("LED02_OFF")
                led02_flag=0
            }
        }
        admin_led03.setOnClickListener{
            if(led03_flag==0){
                publish("LED03_ON")
                led03_flag=1
            }
            else{
                publish("LED03_OFF")
                led03_flag=0
            }
        }
    }
    fun publish(data:String){
        //mqttClient의 publish 기능의 메소드 호출
        mqttClient.publish("admin/led",data)
    }
}