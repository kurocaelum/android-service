package android.imd.serviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private var i: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View){
        i = Intent(applicationContext, TimeService::class.java)
        startService(i)
    }

    fun stop(view: View){
        if(i != null)
            stopService(i)
    }
}
