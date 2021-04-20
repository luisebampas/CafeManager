package com.example.cafe_user.ui.custom


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
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.cafe_user.MainActivity
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.custom_control.*
import org.eclipse.paho.client.mqttv3.MqttMessage
import java.lang.Exception
import java.util.*


class CustomControl : Fragment() {

    lateinit var mqttClient:MyMqtt
    var checkVal:Int=0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_control,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mqttClient = MyMqtt(activity as MainActivity, "tcp://192.168.0.212:1883")

        try{
            mqttClient.connect(arrayOf<String>("Cafe_User/#"))
        }catch (e: Exception){
            e.printStackTrace()
        }

        led_control_view.progress = 85
        led_control_view.max = 100
        light_up.setOnClickListener {
            led_control_view.progress += 1
        }
        light_down.setOnClickListener {
            led_control_view.progress -= 1
        }
        // 테이블 높이 제어


        //var table_height:Int = 50
        table_up.setOnClickListener {
            checkVal=2
            table_height_view.incrementProgressBy(2)
            //table_height+=2
            publish(table_height_view.progress.toString())

        }
        table_down.setOnClickListener {
            table_height_view.incrementProgressBy(-2)
            //table_height-=2
            publish(table_height_view.progress.toString())
        }

        table_height_level1.setOnClickListener {
            checkVal = 1
            table_height_view.progress = 25
            publish("25")
        }
        table_height_level2.setOnClickListener {
            table_height_view.progress = 50
            publish("50")
        }
        table_height_level3.setOnClickListener {
            table_height_view.progress= 75
            publish("75")
        }

        // 블라인드 높이 제어
        blind_up.setOnClickListener {
            blind_height_view.incrementProgressBy(2)
        }
        blind_down.setOnClickListener {
            blind_height_view.incrementProgressBy(-2)
        }
        blind_height_level1.setOnClickListener {
            blind_height_view.progress = 25
        }
        blind_height_level2.setOnClickListener {
            blind_height_view.progress = 50
        }
        blind_height_level3.setOnClickListener {
            blind_height_view.progress = 75
        }

        // 이벤트 처리
        var seekBarListener = object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("test","${fromUser}")
                when (seekBar?.id) {
                    R.id.table_height_view -> {
                        table_height_state.text = "테이블 현재 높이: ${table_height_view.progress}"
                        if(fromUser==true) {
                            publish(table_height_view.progress.toString())
                        }
                    }
                    R.id.blind_height_view -> {
                        blind_height_state.text = "블라인드 현재 높이: ${blind_height_view.progress}"
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        }
        table_height_view.setOnSeekBarChangeListener(seekBarListener)
        blind_height_view.setOnSeekBarChangeListener(seekBarListener)
    }

    fun publish(table_height:String){
        //mqttClient의 publish 기능의 메소드 호출
        mqttClient.publish("mycafe/servo",table_height)
    }


}