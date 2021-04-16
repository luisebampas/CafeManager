package com.example.cafe_user.ui.custom


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.custom_control.*

class CustomControl : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_control,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        led_control_view.progress = 85
        led_control_view.max = 100
        light_up.setOnClickListener {
            led_control_view.progress += 1
        }
        light_down.setOnClickListener {
            led_control_view.progress -= 1
        }

        // 테이블 높이 제어
        table_up.setOnClickListener {
            table_height_view.incrementProgressBy(2)
        }
        table_down.setOnClickListener {
            table_height_view.incrementProgressBy(-2)
        }
        table_height_level1.setOnClickListener {
            table_height_view.progress = 25
        }
        table_height_level2.setOnClickListener {
            table_height_view.progress = 50
        }
        table_height_level3.setOnClickListener {
            table_height_view.progress= 75
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
                when (seekBar?.id) {
                    R.id.table_height_view -> {
                        table_height_state.text = "테이블 현재 높이: ${table_height_view.progress}"
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
}