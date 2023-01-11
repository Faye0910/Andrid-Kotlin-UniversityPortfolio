package com.example.gridview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buildGUI()
    }
    fun buildGUI()
    {
        var images= intArrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,
            R.drawable.pic9,R.drawable.pic10,R.drawable.pic11,R.drawable.pic12,R.drawable.pic13,
            R.drawable.pic14,R.drawable.pic15,R.drawable.pic16,R.drawable.pic17)
        var imgText= arrayOf("pic1","pic2","pic3","pic4","pic5","pic6","pic7","pic8","pic9",
            "pic10","pic11","pic12","pic13","pic14","pic15","pic16","pic17")

        var items=ArrayList<Map<String,Any>>()

        for(i in images.indices)
        {
            var item=HashMap<String,Any>()

            item["image"]=images[i]
            item["text"]=imgText[i]
            items.add(item)
        }

        var adapter=SimpleAdapter(this,items,R.layout.grid_item, arrayOf("image","text"), intArrayOf(R.id.textView1))


        gridViw1.adapter=adapter
        gridViw1.numColumns=3

        gridViw1.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->

            Toast.makeText(this,position.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}
