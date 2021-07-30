package com.kbjay.fragment.hermes

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import com.kbjay.fragment.hermes.bean.Request
import com.kbjay.fragment.hermes.bean.Response
import com.kbjay.fragment.hermes.service.MyService

class SecondActivity : AppCompatActivity() {
    private var proxy :IMyAidlInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bindService(Intent(this, MyService::class.java), object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                proxy = IMyAidlInterface.Stub.asInterface(service)
            }

            override fun onServiceDisconnected(name: ComponentName?) {

            }
        }, Service.BIND_AUTO_CREATE)
    }

    fun request(view: View) {
        val response = proxy?.request(Request("1")) as Response
        Toast.makeText(this,response.data,Toast.LENGTH_LONG).show()
    }
}