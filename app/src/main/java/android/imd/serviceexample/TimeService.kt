package android.imd.serviceexample

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class TimeService : Service() {

    private var worker: TimeWorker? = null
    private var binder = TimeServiceBinder()

    override fun onCreate() {
        super.onCreate()
        worker = TimeWorker()
        Log.i("myapp", "Serviço iniciado")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(worker).start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        worker?.stop()
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    inner class TimeServiceBinder: Binder(){
        val service: TimeService
            get() = this@TimeService
    }

    fun getSeconds(): Int?{
        return worker?.getSeconds()
    }
}
