package com.example.thread3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var thread: MyThread = MyThread(this)
        thread.start()

        button.setOnClickListener {
            thread.setFlag(false)
        }

    }

    @SuppressLint("HandlerLeak")
    val myHandler=object :Handler()   //val為不能更改的變數  這裡為主程式要接收Thread的資料
    {
        override fun handleMessage(msg: Message ){
            super.handleMessage(msg)
            textView.text = msg.what.toString()
        }
    }
}
