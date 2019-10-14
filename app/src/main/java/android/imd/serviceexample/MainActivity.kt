package android.imd.serviceexample

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var i: Intent? = null
    private var service: TimeService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View){
        i = Intent(applicationContext, TimeService::class.java)
        startService(i)

        val conn = TimeServiceConnection()
        bindService(i, conn, 0)
    }

    fun read(view: View){
        val second = service?.getSeconds()
        txt_seconds.text = second.toString()
    }

    fun stop(view: View){
        if(i != null)
            stopService(i)
    }

    inner class TimeServiceConnection: ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onServiceConnected(p0: ComponentName?, iBinder: IBinder?) {
            var binder: TimeService.TimeServiceBinder = iBinder as TimeService.TimeServiceBinder
            this@MainActivity.service = binder.service
        }

    }
}
