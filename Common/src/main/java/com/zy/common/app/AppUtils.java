package com.zy.common.app;

import android.app.Activity;
import android.os.Process;

import java.util.Stack;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public class AppUtils {
    private Stack<Activity> activities;
    private static volatile AppUtils instance=null;
    private AppUtils(){
        activities=new Stack<>();
    }

    public static AppUtils getInstance(){
        if (null==instance){
            synchronized (AppUtils.class){
                if (instance==null){
                    instance=new AppUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 加入新的activity到栈
     * @param activity
     */
    public void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * 从栈中移除到activity
     * @param activity
     */
    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**
     * 关闭activity
     * @param activity
     */
    public void finishActivity(Activity activity){
        if (activity!=null){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

    /**
     * 关闭所有的activity
     */
    public void finishAllActivity(){
        if (activities.size()>0){
            for (Activity activity:
                 activities) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 获取到栈顶的activity
     * @return
     */
    public Activity getTopActivity(){
        if (activities.size()>0){
            return activities.lastElement();
        }
        return null;
    }

    /**
     * 获取指定的Activity
     * @param activityName activity简称（不带包名）
     * @return
     */
    public Activity getActivityBySimpleName(String activityName){
        if (activities.size()>0){
            for (Activity activity:
                 activities) {
                if (activity.getClass().getSimpleName().equals(activityName)){
                    return activity;
                }
            }
        }
        return null;
    }

    /**
     * 退出APP
     */
    public void ExitApp(){
//        System.exit(0);
//        Process.killProcess(Process.myPid());
//        Runtime.getRuntime().exit(0);
        finishAllActivity();
    }
}
