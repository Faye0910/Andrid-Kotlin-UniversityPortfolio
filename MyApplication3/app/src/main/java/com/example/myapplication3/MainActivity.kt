package com.example.myapplication3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener(btn2Listener())
        button3.setOnClickListener(btn3Listener())
        button4.setOnClickListener(btn4Listener())

        button5.setOnClickListener {
           var file:File
            var intent:Intent

            file=File("storage/sdcard/DICM/1582808034.jpg")
            intent= Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.fromFile(file),"image/*")
            startActivity(intent)
        }
    }
    fun btn2Listener():View.OnClickListener=View.OnClickListener {
        var uri:Uri
        var intent:Intent

        uri=Uri.parse("tel::0953960800")        //電話號碼
        intent= Intent(Intent.ACTION_DIAL,uri)          //電話
        startActivity(intent)
    }
    fun btn3Listener():View.OnClickListener=View.OnClickListener {
        var uri:Uri
        var intent:Intent

        uri=Uri.parse("http://www.google.com")   //一定要http不然打不開
        intent= Intent(Intent.ACTION_VIEW,uri)           //view看
        startActivity(intent)
    }
    fun btn4Listener():View.OnClickListener=View.OnClickListener {
        var file:File
        var intent:Intent

        file=File("sdcard/mp3/0001.mp3")
        intent= Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.fromFile(file),"audio/*")
        startActivity(intent)
    }
}
