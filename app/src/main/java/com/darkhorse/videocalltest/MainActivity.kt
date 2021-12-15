package com.darkhorse.videocalltest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telecom.PhoneAccount
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val cm: CallManager = CallManager(this)

        val telecomManager = this.getSystemService(Context.TELECOM_SERVICE) as TelecomManager

        val componentName = ComponentName(this, CallConnectionService::class.java)
        val phoneAccountHandle = PhoneAccountHandle(
            componentName,
            packageName
        )

        val phoneAccount = PhoneAccount.builder(
            phoneAccountHandle,
            packageName
        )
            .setCapabilities(PhoneAccount.CAPABILITY_SELF_MANAGED)
            .build()

        findViewById<Button>(R.id.button_start_call).setOnClickListener { view ->
            try {
                telecomManager.registerPhoneAccount(phoneAccount)

                val isIncomingCallPermitted = telecomManager.isIncomingCallPermitted(phoneAccountHandle)
                Log.i(TAG, "MainActivity - isIncomingCallPermitted - $isIncomingCallPermitted")

                val callInfo = Bundle()
                callInfo.putString("from", "test")
                telecomManager.addNewIncomingCall(phoneAccountHandle, callInfo)
            } catch (e: Exception) {
                Log.e("main activity start call", e.toString())
            }
        }

        findViewById<Button>(R.id.button_end_call).setOnClickListener { view ->
            try {

            } catch (e: Exception) {
                Log.e("main activity end call", e.toString())
            }
        }
    }
}