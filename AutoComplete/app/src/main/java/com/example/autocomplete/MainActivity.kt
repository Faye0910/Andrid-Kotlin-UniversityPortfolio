package com.example.autocomplete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildGUI1()
    }
    fun buildGUI()
    {
        var aryitem:Array<String>            //把東西放進取
        var adapterAry:ArrayAdapter<String>  // 調整器

        aryitem=resources.getStringArray(R.array.placeArray)
        adapterAry= ArrayAdapter(this,android.R.layout.simple_list_item_1,aryitem)   //  放哪,怎麼排列,甚麼東西
        autoCompleteTextView.setAdapter(adapterAry)
    }
    fun buildGUI1()
    {
        var strAry:Array<String>            //把東西放進取
        var adapterAry:ArrayAdapter<String>  // 調整器

        strAry= arrayOf("taipei","taipei government","taipei 101","taichung","taipei railway","tainan")
        adapterAry= ArrayAdapter(this,android.R.layout.simple_list_item_1,strAry)   //  放哪,怎麼排列,甚麼東西
        autoCompleteTextView.setAdapter(adapterAry)
    }

}
