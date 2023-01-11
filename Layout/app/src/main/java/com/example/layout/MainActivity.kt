package com.example.layout

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(btnListener)

        button2.setOnClickListener(View.OnClickListener {

            var  strPath:String="storage/sdcard/DCIM/123.png"
            editText.setText(strPath)

            var f:File= File(strPath)

            if(f.exists()==false)
                Toast.makeText(this,"檔案不存在",Toast.LENGTH_SHORT).show()
            else{
                Toast.makeText(this,"檔案存在",Toast.LENGTH_SHORT).show()
                imageView.setImageBitmap(getBmp(strPath))
            }

        })

    }
    fun getBmp(strFile: String):Bitmap{

        var bmp :Bitmap=BitmapFactory.decodeFile(strFile)
        return bmp

    }

    val btnListener : View.OnClickListener=View.OnClickListener {

        imageView.setImageResource(R.drawable.a1)
    }

}
