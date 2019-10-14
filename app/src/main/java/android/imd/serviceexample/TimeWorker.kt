package android.imd.serviceexample

import android.os.SystemClock
import android.util.Log

class TimeWorker : Runnable{

    @Volatile
    private var running: Boolean = false
    private var seconds: Int = 0

    override fun run() {
        running = true
        seconds++
        Log.i("myapp", "Segundos = $seconds")
        SystemClock.sleep(1000)
    }

    fun stop(){
        running = false
    }

}