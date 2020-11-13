package com.zy.common.log;

import android.util.Log;

import com.zy.common.BuildConfig;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public class ZLog {
    private static final String TAG="bawei6";
    public static void d(String log){
        if (BuildConfig.DEBUG){
            Log.d(TAG,log);
        }

    }
    public static void d(String tag,String log){

        if (BuildConfig.DEBUG){
            Log.d(TAG,tag+" -> "+log);
        }
    }
    public static void i(String log){

        if (BuildConfig.DEBUG){
            Log.i(TAG,log);
        }
    }
    public static void i(String tag,String log){

        if (BuildConfig.DEBUG){
            Log.i(TAG,tag+" -> "+log);
        }
    }
    public static void w(String log){

        if (BuildConfig.DEBUG){
            Log.w(TAG,log);
        }
    }
    public static void w(String tag,String log){

        if (BuildConfig.DEBUG){
            Log.w(TAG,tag+" -> "+log);
        }
    }
    public static void e(String log){

        if (BuildConfig.DEBUG){
            Log.e(TAG,log);
        }
    }
    public static void e(String tag,String log){

        if (BuildConfig.DEBUG){
            Log.e(TAG,tag+" -> "+log);
        }
    }
}
