package com.example.a0519scrollview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildGUI()
    }

    fun buildGUI()
    {
        var imgId= arrayOf(R.drawable.a111,R.drawable.a2,R.drawable.a15,R.drawable.a17)
        for (i in 0..3)
        {
            linearLayout1.addView(addImg(imgId[i]))
        }

    }

    fun addImg (imgId:Int) : ImageView {
        val imageView=ImageView(this)
        val param1=LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        param1.setMargins(10,5,10,5)
        param1.gravity=Gravity.TOP    //排版告上

        imageView.layoutParams=param1    //把排版給layout
        imageView.setImageResource(imgId)
        return imageView
    }

}
