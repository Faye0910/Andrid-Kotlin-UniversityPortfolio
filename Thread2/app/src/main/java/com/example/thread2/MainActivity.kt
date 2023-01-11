package com.example.thread2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var num:Int=0
    var fg:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener() {

            //-------------handler-------------------
            var myHandler=@SuppressLint("HandlerLeak")
            object :Handler(){

                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    var num=msg.what
                    textView.text="數字=$num"
                }
            }
            //------------Thread------------------
            Thread{
                var msg=Message()
                msg.what=++num
                myHandler.sendMessage(msg)
                Thread.sleep(1000)
            }.start()
        }

        //-------------------------------------------------------------
        button2.setOnClickListener {

            var myHandler = @SuppressLint("HandlerLeak")
            object : Handler() {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    var num = msg.what
                    textView.text = "數字=$num"
                }
            }

            Thread{
                while (true)
                {
                    if(fg)
                        myHandler.sendEmptyMessage(++num)
                    Thread.sleep(1000)
                }
            }.start()

            button2.isEnabled=false
            button3.isEnabled=true
        }

        //----------------------------------------------------------
       button3.setOnClickListener {
            if(button3.text.equals("start thread2"))
            {
                button3.text="stop thread2"
                fg=true
            }
           else
            {
                button3.text="start thread2"
                fg=false
            }
        }
    }
}