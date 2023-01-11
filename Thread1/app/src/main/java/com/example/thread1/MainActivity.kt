package com.example.thread1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var thread:MyThread= MyThread(this)
        thread.start()

    }
    //**************宣告Handler型別的變數，不可以為韓式
    @SuppressLint("HandlerLeak")
    val myHandler=object :Handler()   //val為不能更改的變數  這裡為主程式要接收Thread的資料
    {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            textView.text=msg.what.toString()
            when(msg.what)

            {
                0->
                    imageView.setImageResource(R.drawable.lena)
                1->
                    imageView.setImageResource(R.drawable.a111)
                2->
                    imageView.setImageResource(R.drawable.a2)
                3->
                    imageView.setImageResource(R.drawable.a111)
            }
        }

    }

}
