package com.lixiang.AIDLServer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
        Log.i("MyService", "创建");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();//return MyBinder通过ServiceConnection在activity中拿到MyBinder
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplication(), 0, activityIntent, 0);
        Notification notification = new Notification.Builder(getApplication()).setAutoCancel(true).
                setTicker("前台Service启动").setContentTitle("前台Service运行中").
                setContentText("这是一个正在运行的前台Service").setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).build();
        startForeground(1, notification);


        return super.onStartCommand(intent, flags, startId);
    }

    public void payService() {
        Log.i("MyService", "payService: --------");
    }

    class MyBinder extends IPay.Stub {
        public void pay() {
            payService();
        }//通过Binder实例将service中的方法暴露出去
    }
}