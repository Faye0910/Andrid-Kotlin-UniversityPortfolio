package com.example.thread3

class MyThread():Thread() {

    lateinit var activity: MainActivity
    var picNo:Int=0
    var fg:Boolean=false

        constructor(activity: MainActivity):this()
        {
            this.activity=activity  //加this為第5行的變數 後面則為新宣告的
        }

        override fun run()  {  //為執行緒裡主要要執行的地方


            while (fg)
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
            activity.myHandler.sendEmptyMessage(-100)

        }
    public fun setFlag(fg:Boolean)
    {
        this.fg=fg
    }
    }
