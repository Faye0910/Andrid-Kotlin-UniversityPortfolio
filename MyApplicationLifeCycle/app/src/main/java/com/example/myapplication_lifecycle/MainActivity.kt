package com.example.myapplication_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var stdScore:Int=0
    var stdName:String=""

    override fun onCreate(savedInstanceState: Bundle?) {    //Bundle?的問號是指它是變數
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"OnCreate",Toast.LENGTH_SHORT).show()

        button.setOnClickListener(btnListener())
    }

    fun btnListener():View.OnClickListener=View.OnClickListener {

        stdName=editText.text.toString()
        stdScore=editText2.text.toString().toInt()
    }

    override fun onStart() { //已經設定好的
        super.onStart()  //之前已經定義好了的原本城式

        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show()

    }


    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Toast.makeText(this,"onSaveInstanceState",Toast.LENGTH_SHORT).show()

        outState.putString("stdName",stdName)
        outState.putInt("stdScore",stdScore)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        Toast.makeText(this,"onRestoreInstanceState",Toast.LENGTH_SHORT).show()

        if(savedInstanceState!=null)
        {
            stdName=savedInstanceState.getString("stdName").toString()
            stdScore=savedInstanceState.getInt("stdScore")

            textView3.text=stdName
            textView4.text=stdScore.toString()
        }
    }

}
