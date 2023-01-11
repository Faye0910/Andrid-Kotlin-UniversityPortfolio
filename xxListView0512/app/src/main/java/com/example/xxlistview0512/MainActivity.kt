package com.example.xxlistview0512

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buidGUI()
    }
    fun buidGUI()
    {
        var mapAry:List<Map<String,Any>>  //索引map每個節點包含( key=String 值=Any圖形編號)
        var iconImg:IntArray //沒有StringAry所以要用這個然後用泛型
        var strList:Array<String>  //泛型
        var adapterList:ListAdapter
        var item:HashMap<String,Any>


        iconImg= intArrayOf(R.drawable.edu1,R.drawable.edu2,R.drawable.edu3
                            ,R.drawable.edu4,R.drawable.edu5,R.drawable.edu6)  //拿圖片


        strList=resources.getStringArray(R.array.lvEduList)  //讀到字了

        //var strList= arrayOf(this.resources.getStringArray(R.array.lvEduList))也可以這樣寫

        mapAry=ArrayList<Map<String,Any>>()

        for (i in strList.indices)//indicest長度
        {
            item=HashMap<String,Any>()  //宣告 配置記憶體

            item.put("imgView",iconImg[i])
            item.put("txtView",strList[i])
            mapAry.add(item)
        }

        adapterList=SimpleAdapter(this,mapAry,R.layout.listitem, arrayOf("imgView","txtView"),
            intArrayOf(R.id.imageView1,R.id.textView1))

        listView1.adapter=adapterList

        listView1.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
        }

    }
}
