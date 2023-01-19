package com.shivamgupta.notifyme

import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationListener : NotificationListenerService() {

    val context: Context by lazy { applicationContext }
    val TAG = "NotificationListener"

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        sbn?.let {
            val extras = sbn.notification.extras
            val notificationTitle = extras.getString("android.title")
            val notificationContent = extras.getCharSequence("android.text").toString()

            Log.i(TAG,"title: $notificationTitle, content: $notificationContent")
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
    }
}