package com.leral3.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

//01. 클릭 이벤트를 처리 인터페이스 (View.OnClickListener)
class MainActivity : AppCompatActivity(), View.OnClickListener {

    var isRunning = false //02. 실행 여부 확인용 변수

    var timer: Timer? = null


    //03. 뷰 가저오기
    private lateinit var btn_start:Button
    private lateinit var btn_refresh: Button
    private lateinit var tv_millisecond: TextView
    private lateinit var tv_second: TextView
    private lateinit var tv_minute: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //04. 버튼별 OnClickListener 등록
        btn_start.setOnClickListener(this)
        btn_refresh.setOnClickListener(this)
    }


    //05. 클릭 이벤트 처리
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_start -> {
                if(isRunning) {
                    pause()
                }else {
                    start()
                }
            }
            R.id.btn_refresh -> {
                refresh()
            }
        }
    }

    private fun start() {
        //06. 스톱워치 측정을 시작하는 로직

    }

    private fun pause() {
        //07. 스톱워치 측정을 일시정지하는 로직

    }

    private fun refresh() {
        //08. 초기화하는 로직
    }
}