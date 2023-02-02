package com.lixiang.AIDLServer;

import android.app.Service;
import android.content.Intent;
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