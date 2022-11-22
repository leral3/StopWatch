package com.leral3.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

//01. 클릭 이벤트를 처리 인터페이스 (View.OnClickListener)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    var isRunning = false //02. 실행 여부 확인용 변수

    var timer: Timer? = null //09. timer 변수 추가
    var time = 0 //10. time 변수 추가


    //03. 뷰 가저오기
    private lateinit var btn_start:Button
    private lateinit var btn_refresh: Button
    private lateinit var btn_laptime: Button
    private lateinit var tv_millisecond: TextView
    private lateinit var tv_second: TextView
    private lateinit var tv_minute: TextView
    private lateinit var lapLayout: LinearLayout
    private var lap = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start = findViewById(R.id.btn_start)
        btn_refresh = findViewById(R.id.btn_refresh)
        btn_laptime = findViewById(R.id.btn_laptime)
        tv_millisecond = findViewById(R.id.tv_millisecond)
        tv_second = findViewById(R.id.tv_second)
        tv_minute = findViewById(R.id.tv_minute)
        lapLayout = findViewById(R.id.lapLayout)


        //04. 버튼별 OnClickListener 등록
        btn_start.setOnClickListener(this)
        btn_refresh.setOnClickListener(this)
        btn_laptime.setOnClickListener(this)
    }


    //05. 클릭 이벤트 처리
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_start -> {
                if(isRunning) {
                    pause()
                } else {
                    start()
                }
            }
            R.id.btn_refresh -> {
                refresh()
            }
            R.id.btn_laptime -> {
                recordLap()
            }
        }
    }

    fun start() {
        //06. 스톱워치 측정을 시작하는 로직

        btn_start.text = "일시정지"
        btn_start.setBackgroundColor(getColor(R.color.red))
        isRunning = true


        //11. 스톱워치를 시작하는 로직
        timer = timer(period = 10 ){

            time ++ //12. 10밀리초 단위 타이머

            val milli_second = time % 100
            val second = (time % 6000) / 100
            val minute = time / 6000

            runOnUiThread {
                if (isRunning) {
                    tv_millisecond.text =
                        if (milli_second < 10 ) ".0${milli_second}" else ".${milli_second}"
                    tv_second.text =
                        if (second < 10) ":0${second}" else ":${second}"
                    tv_minute.text = "${minute}"
                }
            }
        }
    }

    fun pause() {
        //07. 스톱워치 측정을 일시정지하는 로직

        btn_start.text = "시작"
        btn_start.setBackgroundColor(getColor(R.color.blue))

        isRunning = false
        timer?.cancel()

    }

    fun refresh() {
        //08. 초기화하는 로직

        timer?.cancel()  // 백그라운드 타이머 멈추기
        lapLayout.removeAllViews()

        btn_start.text = "시작"
        btn_start.setBackgroundColor(getColor(R.color.blue))
        isRunning=false

        time = 0
        tv_millisecond.text = ".00"
        tv_second.text = ":00"
        tv_minute.text = "00"
    }

    fun recordLap() {
        val laptime = time
        val textView = TextView(this)

        textView.text = "$lap LAP : ${laptime / 6000} : ${(laptime % 6000) / 100} . ${laptime % 100}"

        lapLayout.addView(textView, 0)
        lap++
    }

}