package com.example.a0519scrollview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.setMargins
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildGUI()
    }

    fun buildGUI()
    {
        val imageView1=ImageView(this)
        val param1=LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

         param1.setMargins(10,5,10,5)
         param1.gravity=Gravity.TOP    //排版告上

        imageView1.layoutParams=param1    //把排版給layout
        imageView1.setImageResource(R.drawable.a111)
        linearLayout1.addView(imageView1)

        imageView1.setOnClickListener {
            Toast.makeText(this,it.id.toString(),Toast.LENGTH_SHORT).show()
        }


    }
}
