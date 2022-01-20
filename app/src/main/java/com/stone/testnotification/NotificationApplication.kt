package com.stone.testnotification

import android.app.Application
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

class NotificationApplication : Application() {
    override fun onCreate() {
        super.onCreate()


        //for topic
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        FirebaseMessaging.getInstance().subscribeToTopic("all")
            .addOnCompleteListener { task ->
                if (!task.isSuccessful)
                    Log.i("topic", "fail")
                else
                    Log.i("topic", "success")

            }
    }
}