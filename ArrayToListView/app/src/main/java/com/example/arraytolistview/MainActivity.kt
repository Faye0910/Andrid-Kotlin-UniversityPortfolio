package com.example.arraytolistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buildGUI()
        buildGUI1()
    }
   /* fun gui()//用listview
    {
        var aryEduList:ArrayAdapter<CharSequence>   //丟到listView裡面 用字串的方式顯示CharSequence(跟著前面型態

        aryEduList= ArrayAdapter.createFromResource(this,R.array.lvEduList,android.R.layout.simple_list_item_1)
        //這個aryEduList要用andriod...方式顯示排列
        ListView1.adapter=aryEduList


    }*/
    fun buildGUI()
    {
        var adptEduList:ArrayAdapter<CharSequence>  //等進來再決定是甚麼資料型態{泛型}
        adptEduList= ArrayAdapter.createFromResource(this/*哪裡要*/,R.array.lvEduList/*資源在哪*/,android.R.layout.simple_spinner_item/*塞在哪排版樣式*/)
        adptEduList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)//排版比較不會靠一起
        spinner.adapter=adptEduList  /*或是spinner.setAdapter(adptEduList)讓spinner將剛剛設定的東西顯示*/
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            //讓他可以選擇在spinner上面顯示
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,position.toString(),Toast.LENGTH_LONG).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
//================================================================================================================================
    fun buildGUI1()
    {
        var strArray= arrayOf("國小","國中","高中","大學","研究所")//宣告陣列的方式
        val adapter=ArrayAdapter(this/*在哪*/,android.R.layout.simple_spinner_dropdown_item/*排版*/,strArray/*內容*/)
        spinner.adapter=adapter/*讓spinner將剛剛設定的東西顯示*/
    }
//================================================================================================================================
    fun spListener():AdapterView.OnItemSelectedListener=object:AdapterView.OnItemSelectedListener{
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ) {
            Toast.makeText(this@MainActivity,position.toString(),Toast.LENGTH_LONG).show()
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }
}
