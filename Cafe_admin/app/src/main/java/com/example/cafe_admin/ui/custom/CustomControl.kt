package com.example.cafe_admin.ui.custom


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.cafe_admin.MainActivity
import com.example.cafe_admin.R
import kotlinx.android.synthetic.main.custom_control.*
import org.eclipse.paho.client.mqttv3.MqttMessage
import java.lang.Exception
import java.util.*


class CustomControl : Fragment() {

    lateinit var mqttClient:MyMqtt
    var checkVal:Int=0
    var LEDdata:String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.environment_control,container,false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        mqttClient = MyMqtt(activity as MainActivity, "tcp://192.168.0.212:1883")
//
//        try{
//            mqttClient.connect(arrayOf<String>("mycafe/#"))
//        }catch (e: Exception){
//            e.printStackTrace()
//        }
//
//        led_control_view.progress = 85
//        led_control_view.max = 100
//        light_up.setOnClickListener {
//            led_control_view.progress += 5
//            LEDdata = "light_up"
//            publish2(LEDdata)
//        }
//
//        light_down.setOnClickListener {
//            led_control_view.progress -= 5
//            LEDdata = "light_down"
//            publish2(LEDdata)
//        }
//        // 테이블 높이 제어
//
//
//        //var table_height:Int = 50
//        table_up.setOnClickListener {
//            checkVal=2
//            table_height_view.incrementProgressBy(5)
//            //table_height+=2
//            publish("t"+ table_height_view.progress.toString())
//
//        }
//        table_down.setOnClickListener {
//            table_height_view.incrementProgressBy(-5)
//            //table_height-=2
//            publish("t"+ table_height_view.progress.toString())
//        }
//
//        table_height_level1.setOnClickListener {
//            checkVal = 1
//            table_height_view.progress = 25
//            publish("t25")
//        }
//        table_height_level2.setOnClickListener {
//            table_height_view.progress = 50
//            publish("t50")
//        }
//        table_height_level3.setOnClickListener {
//            table_height_view.progress= 75
//            publish("t75")
//        }
//
//        // 블라인드 높이 제어
//        blind_up.setOnClickListener {
//            blind_height_view.incrementProgressBy(2)
//            publish3("b"+ blind_height_view.progress.toString())
//        }
//        blind_down.setOnClickListener {
//            blind_height_view.incrementProgressBy(-2)
//            publish3("b"+ blind_height_view.progress.toString())
//        }
//        blind_height_level1.setOnClickListener {
//            blind_height_view.progress = 25
//            publish3("b25")
//        }
//        blind_height_level2.setOnClickListener {
//            blind_height_view.progress = 50
//            publish3("b50")
//        }
//        blind_height_level3.setOnClickListener {
//            blind_height_view.progress = 75
//            publish3("b75")
//        }
//
//        // 이벤트 처리
//        var seekBarListener = object: SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                Log.d("test","${fromUser}")
//                when (seekBar?.id) {
//                    R.id.table_height_view -> {
//                        table_height_state.text = "테이블 현재 높이: ${table_height_view.progress}"
//                        if(fromUser==true) {
//                            publish("t"+ table_height_view.progress.toString())
//                        }
//                    }
//                    R.id.blind_height_view -> {
//                        blind_height_state.text = "블라인드 현재 높이: ${blind_height_view.progress}"
//                        if(fromUser==true) {
//                            publish3("b"+ blind_height_view.progress.toString())
//                        }
//                    }
//                }
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//            }
//
//        }
//        table_height_view.setOnSeekBarChangeListener(seekBarListener)
//        blind_height_view.setOnSeekBarChangeListener(seekBarListener)
//    }
//
//    fun publish(data:String){
//        //mqttClient의 publish 기능의 메소드 호출
//        mqttClient.publish("mycafe/servo",data)
//    }
//
//    fun publish2(data:String){
//        //mqttClient의 publish 기능의 메소드 호출
//        mqttClient.publish("mycafe/ledCustom",data)
//    }
//
//    fun publish3(data:String){
//        //mqttClient의 publish 기능의 메소드 호출
//        mqttClient.publish("mycafe/blind",data)
//    }
}