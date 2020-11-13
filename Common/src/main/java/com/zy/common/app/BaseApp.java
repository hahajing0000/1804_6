package com.zy.common.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public abstract class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        registerActivityLifecycleCallBacks();
    }

    private void registerActivityLifecycleCallBacks() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                AppUtils.getInstance().addActivity(activity);
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                AppUtils.getInstance().removeActivity(activity);
            }
        });
    }

    protected abstract void init();
}
