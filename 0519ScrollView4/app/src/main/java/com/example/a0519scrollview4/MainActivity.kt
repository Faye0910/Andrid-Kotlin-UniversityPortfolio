package com.example.a0519scrollview4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        button1.setOnClickListener(btnListener())
    }
    fun btnListener():View.OnClickListener=View.OnClickListener {
        var imgView:ImageView
        var imgId:Array<Int>
        var btn:Button

        imgId= arrayOf(R.drawable.a111,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a2)

        for(i in 0..3)
        {
            imgView=addImg(imgId[i],i)
            linearlayout1.addView(imgView)
        }

        btn=it as Button
        btn.setTextColor(Color.GREEN)
        btn.isClickable=false
    }


    fun addImg (imgId:Int,vId:Int) : ImageView {
        val imageView=ImageView(this)
        val param1=LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)

        param1.setMargins(10,5,10,5)
        param1.gravity=Gravity.TOP    //排版告上

        imageView.layoutParams=param1    //把排版給layout
        imageView.setImageResource(imgId)

        imageView.id=vId
        imageView.setOnClickListener(imgListener())

        return imageView
    }
    fun imgListener():View.OnClickListener=View.OnClickListener {

        var vId:Int
        vId=(it as ImageView).id

        Toast.makeText(this,vId.toString(),Toast.LENGTH_SHORT).show()
    }
}
