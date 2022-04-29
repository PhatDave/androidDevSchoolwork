package com.example.lv4;

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat


fun getChannelId(name: String): String = "channel_$name"
        const val CHANNEL_MAIN = "MainChannel"


@RequiresApi(api = Build.VERSION_CODES.O)
fun createNotificationChannel(name: String, description: String, importance: Int): NotificationChannel {
        val channel = NotificationChannel(getChannelId(name), name, importance)
        channel.description = description
        channel.setShowBadge(true)
        return channel
}

@RequiresApi(api = Build.VERSION_CODES.O)
fun createNotificationChannels(context: Context) {
        val channels = mutableListOf<NotificationChannel>()
        channels.add(createNotificationChannel(
                CHANNEL_MAIN,
                "URGENT PANIC AAAAAAAAAAA",
                NotificationManagerCompat.IMPORTANCE_HIGH
        ))
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannels(channels)
}