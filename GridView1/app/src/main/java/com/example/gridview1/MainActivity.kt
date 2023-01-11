package com.example.gridview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildGUI()
        gvListener()
    }
    fun buildGUI()
    {
        gridView1.adapter=ImageAdapter(this)
    }

    //第一種方法
    /*fun gvListener():AdapterView.OnItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->

        Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()

    }*/

    //第二種
    //使用object:AdapterView也可以，這時需要Generate->implement去產生onItemClick樣板
    fun gvListener():AdapterView.OnItemClickListener=object :AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            Toast.makeText(this@MainActivity,position.toString(),Toast.LENGTH_SHORT).show()

            //下面這個Toast.makeText，使用context:this會發生錯誤
            //Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
        }
    }



}
