package com.zy.mvvm.cmd.view;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.zy.mvvmcore.cmd.BindCmd;

import java.util.concurrent.TimeUnit;

import androidx.databinding.BindingAdapter;
import io.reactivex.functions.Consumer;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public class ViewAdapter {

    @BindingAdapter({"onClick"})
    public static void onClickListener(View view, final BindCmd cmd){
        RxView.clicks(view).throttleFirst(3, TimeUnit.SECONDS).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                if (cmd!=null){
                    cmd.Execute();
                }
            }
        });
    }
}
