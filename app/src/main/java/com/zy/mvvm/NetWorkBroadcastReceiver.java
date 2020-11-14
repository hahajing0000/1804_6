package com.zy.mvvm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author:zhangyue
 * @date:2020/11/14
 */
public class NetWorkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("123","network changed");
    }
}
