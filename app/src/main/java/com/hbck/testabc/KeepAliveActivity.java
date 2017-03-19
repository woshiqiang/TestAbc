package com.hbck.testabc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017-03-19.
 */

public class KeepAliveActivity extends Activity {
    private static final String TAG = "KeepAliveActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "KeepLiveActivity----onCreate!!!");
        Window window = getWindow();
        window.setGravity(Gravity.LEFT|Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = 1;
        params.height = 1;
        params.x = 0;
        params.y = 0;
        window.setAttributes(params);

        KeepLiveActivityManager.getInstance(this).setKeepLiveActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "KeepLiveActivity----onDestroy!!!");
    }
}
