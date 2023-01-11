package com.example.thread1

import java.lang.Exception

class MyThread():Thread()
{
    lateinit var activity: MainActivity //lateinit為事後再給值
    var picNo:Int=1

    constructor(activity: MainActivity):this()
    {
        this.activity=activity  //加this為第5行的變數 後面則為新宣告的
    }

    override fun run()  {  //為執行緒裡主要要執行的地方


       while (true)
       {
           picNo=(++picNo)%4
           activity.myHandler.sendEmptyMessage(picNo)   //這邊的picno就是到MainActivity的msg的what
           try {                                        //超過一秒要用TRY CATCH因為怕她禿然被終止
               Thread.sleep(2000)
           }
           catch (e:Exception)
           {
                e.printStackTrace()
           }

       }
    }
}