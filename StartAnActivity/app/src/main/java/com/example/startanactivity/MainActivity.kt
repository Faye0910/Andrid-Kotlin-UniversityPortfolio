package com.example.startanactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login3.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildview()
    }

    fun buildview(){
        button.setOnClickListener(btn1Listener)
        button2.setOnClickListener(btn2Listener())
        button3.setOnClickListener(btn3Listener())
    }

    var btn1Listener: View.OnClickListener=View.OnClickListener {
        var it:Intent
        it= Intent()

        it.setClass(this, Login::class.java)
        startActivity(it)
    }

    fun btn2Listener(): View.OnClickListener=View.OnClickListener {
        var strName:String
        var strSex:String
        var it:Intent= Intent()
        var bl:Bundle= Bundle()

        strName=editText.text.toString()
        strSex=editText2.text.toString()
        it.setClass(this,Login2::class.java)

        bl.putString("Name",strName)
        bl.putString("sex",strSex)
        it.putExtras(bl)
        startActivity(it)
    }

    fun btn3Listener(): View.OnClickListener=View.OnClickListener {
        var strName:String
        var strSex:String
        var it:Intent= Intent()
        var bl:Bundle= Bundle()

        strName=editText.text.toString()
        strSex=editText2.text.toString()
        it.setClass(this,Login3::class.java)

        bl.putString("Name",strName)
        bl.putString("sex",strSex)
        it.putExtras(bl)

        startActivityForResult(it,0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var str:String=""

        if(requestCode!=0)
            return

        when(resultCode)
        {
            RESULT_OK->{
                str=data?.getStringExtra("sayHello").toString()
            }
            RESULT_CANCELED->
            {
                str="發生錯誤"
            }
        }

        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()


    }
}
