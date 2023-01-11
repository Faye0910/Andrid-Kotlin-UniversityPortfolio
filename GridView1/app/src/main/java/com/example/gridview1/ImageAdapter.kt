package com.example.gridview1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(var mContext:Context):BaseAdapter()   //Mcontextt傳給BaseAdapter 繼承跟呼叫BaseAdapter
{
    var thumbs= intArrayOf(R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
                            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
                            R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,
        R.drawable.pic10,R.drawable.pic11,R.drawable.pic12,R.drawable.pic13,
        R.drawable.pic14,R.drawable.pic15,R.drawable.pic16,R.drawable.pic17)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //第一次執行看到圖
        var imageView:ImageView  //一個影像

        if(convertView==null)  //是否曾經載過
        {
            imageView=ImageView(mContext)  //分配記憶體
            imageView.layoutParams=AbsListView.LayoutParams(130,130)  //大小
            imageView.scaleType=ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8,8,8,8) //旁邊間隔
        }
        else
        {
            imageView=convertView as ImageView  //資料轉型
        }

        imageView.setImageResource(thumbs[position])
        return imageView
    }

    override fun getItem(position: Int): Any {
       return thumbs [position]  //選道地幾個圖片的資源黨
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()   //得到
    }

    override fun getCount(): Int {
        return thumbs.size  //陣列數量
    }
}