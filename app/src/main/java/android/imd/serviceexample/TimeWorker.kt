package android.imd.serviceexample

import android.os.SystemClock
import android.util.Log

class TimeWorker : Runnable{

    @Volatile
    private var running: Boolean = false
    private var seconds: Int = 0

    override fun run() {
        running = true
        while(running){
            incrementSeconds()
            Log.i("myapp", "Segundos = ${getSeconds()}")
            SystemClock.sleep(1000)
        }
    }

    @Synchronized
    private fun incrementSeconds(){
        seconds++
    }

    fun getSeconds(): Int{
        return this.seconds
    }

    fun stop(){
        running = false
    }

}