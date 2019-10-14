package android.imd.serviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TimeService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
