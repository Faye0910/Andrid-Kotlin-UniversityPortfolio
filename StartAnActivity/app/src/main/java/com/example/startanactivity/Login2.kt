package com.example.startanactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login2.*

class Login2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        bulidView();
    }

    fun bulidView(){
        var strName:String
        var strSex:String
        var bl:Bundle?

        bl=this.intent.extras

        if(bl!=null)
        {
            strName=bl.getString("Name").toString()
            strSex=bl.getString("Sex").toString()

            if(strSex.equals("男"))
                textView3.text=strName+"先生，您好"
            else
                textView3.text=strName+"小姐，您好"
        }

    }
}

