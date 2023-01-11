  package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

  class MainActivity : AppCompatActivity() {
    var sex:String?=null  //要有?=才能用null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun build(){
        button.setOnClickListener(btnListener())
        radioGroup.setOnCheckedChangeListener(rdGpListner())
    }

      fun btnListener():View.OnClickListener=View.OnClickListener {
          var name:String
          if(sex.isNullOrEmpty())         //等同 ==null
              return@OnClickListener
          name=editText1.text.toString()
          Toast.makeText(this,name+","+sex,Toast.LENGTH_SHORT).show()

      }

      fun rdGpListner():RadioGroup.OnCheckedChangeListener=RadioGroup.OnCheckedChangeListener { group, checkedId ->
          var rdchecked:Int
          rdchecked=radioGroup.checkedRadioButtonId

          when(rdchecked)
          {
              R.id.radioButton3->
                  sex="男"
              R.id.radioButton4->
                  sex="女"
              else->
                  sex="無"
          }
      }
}