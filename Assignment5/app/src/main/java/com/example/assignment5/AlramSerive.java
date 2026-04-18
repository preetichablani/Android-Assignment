package com.example.assignment5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class AlramSerive extends BroadcastReceiver {

    public static MediaPlayer mediaPlayer;
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "alram triggered",Toast.LENGTH_LONG).show();
        mediaPlayer=MediaPlayer.create(context, Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.start();
        Intent intent1 = new Intent(context,stopAlarm.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,1,intent1,PendingIntent.FLAG_IMMUTABLE);
        NotificationManager manager=(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        String channel_id="alram_Channel";

            NotificationChannel channel= null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel = new NotificationChannel(channel_id, "Alram Notification", NotificationManager.IMPORTANCE_HIGH);

                manager.createNotificationChannel(channel);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channel_id)
                        .setSmallIcon(R.drawable.round_add_alarm_24)
                        .setContentTitle("Alram Notification")
                        .setContentText("Wake Up")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .setAutoCancel(false)
                        .addAction(R.drawable.round_add_alarm_24, "Cancel", pendingIntent);
                manager.notify(1, builder.build());
            }
        }
    }
