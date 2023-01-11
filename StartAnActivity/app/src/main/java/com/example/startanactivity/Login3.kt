package com.example.startanactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class Login3 : AppCompatActivity() {
    var str:String=String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login3)
        buildView()

        button4.setOnClickListener(View.OnClickListener {
            var it:Intent= Intent()
            var bl:Bundle=Bundle()

            bl.putString("sayHello",str)
            it.putExtras(bl)
            setResult(RESULT_OK,it)
            finish()

        })
    }
    fun buildView()
    {
        var strName:String
        var strSex:String;


        strName=this.intent.getStringExtra("Name")
        strSex=this.intent.getStringExtra("Sex")

        if(strSex.equals("男"))
            textView6.text = strName + "先生，你好"
        else
            textView6.text = strName + "小姐，妳好"

        str=textView6.text.toString()

    }
}
