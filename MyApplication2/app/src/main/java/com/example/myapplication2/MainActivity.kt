package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //全域變數區域(要給初始值)
    //var btn:Button= Button(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView.text="123123"
        //btn=findViewById(R.layout)

        button.setOnClickListener(btnListener)

        button2.setOnClickListener {   //有大括弧 就是直接寫程式碼
            textView.setText("second method")
        }

        button3.setOnClickListener(View.OnClickListener {
            textView.setText("3rd method")
        })

        button4.setOnClickListener(btnListener)
    }

    //val不會被改變
    val btnListener:View.OnClickListener=View.OnClickListener {v:View->

        when(v.id) {  //就像swich catch

            R.id.button ->
                Toast.makeText(this,"from button",Toast.LENGTH_SHORT).show()  //像messagebox
            R.id.button4 ->
                Toast.makeText(this,"from button4",Toast.LENGTH_SHORT).show()

        }
    }




}
