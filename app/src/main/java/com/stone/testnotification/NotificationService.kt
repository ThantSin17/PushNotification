package com.stone.testnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "com.stone.testnotification"
const val channelName = "STONE"

class NotificationService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.i("messageReceive:", remoteMessage.notification?.title.toString())
        sentNotification(remoteMessage)
    }

    private fun sentNotification(remoteMessage: RemoteMessage) {
        val title = remoteMessage.notification?.title
        val body = remoteMessage.notification?.body

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_noti)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel =
            NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        channel.description = "Description"
        channel.setShowBadge(true);
        channel.canShowBadge();
        channel.enableLights(true);
        channel.enableVibration(true);

        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(0,builder.build())


    }
}

