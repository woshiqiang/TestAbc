package com.hbck.testabc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ScreenListener listener = new ScreenListener(this);
        listener.begin(new ScreenListener.ScreenStateListener() {

            @Override
            public void onUserPresent() {
                Log.e("MyService","onUserPresent");
            }

            @Override
            public void onScreenOn() {
                // 开屏---finish这个一个像素的Activity
                Log.e("MyService","onScreenOn");
                KeepLiveActivityManager.getInstance(MyService.this).finishKeepLiveActivity();
            }

            @Override
            public void onScreenOff() {
                // 锁屏---启动一个像素的Activity
                Log.e("MyService","onScreenOff");
                KeepLiveActivityManager.getInstance(MyService.this).startKeepLiveActivity();
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService","onDestroy");
    }
}
