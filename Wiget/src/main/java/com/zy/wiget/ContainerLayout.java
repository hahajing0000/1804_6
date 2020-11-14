package com.zy.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.zy.wiget.errorview.ContainerState;
import com.zy.wiget.errorview.View404;
import com.zy.wiget.errorview.View500;
import com.zy.wiget.errorview.ViewError;
import com.zy.wiget.errorview.ViewNoNet;

import java.lang.reflect.Constructor;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2020/11/14
 */
public class ContainerLayout extends LinearLayout {
    private Context mContext;

    public ContainerLayout(Context context) {
        super(context);
        init(context);
    }

    public ContainerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public ContainerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 容器的初始化
     */
    private void init(Context context) {
        this.mContext = context;
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.setLayoutParams(layoutParams);
    }

    /**
     * 根据容器状态枚举来替换显示View的方法
     * @param state
     */
    public void ChangeWrongView(ContainerState state){
        switch (state){
            case _404:
                replaceRootView(View404.class);
                break;
            case _500:
                replaceRootView(View500.class);
                break;
            case NONET:
                replaceRootView(ViewNoNet.class);
                break;
            case ERROR:
                replaceRootView(ViewError.class);
                break;
        }
    }

    /**
     * 更换容器布局的子View方法
     * @param view
     */
    public void replaceView(View view){
        addRootView(view);
    }

    /**
     * 替换跟布局
     *
     * @param view
     */
    private void replaceRootView(Class<?> view) {
        View subView = createInstance(view);
        addRootView(subView);
    }

    private void addRootView(View subView){
        this.removeAllViews();
        this.addView(subView);
    }

    /**
     * 根据类型创建类型实例
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T createInstance(Class<?> clazz) {
        Constructor<?> constructor = null;
        try {
            constructor = clazz.getConstructor(Context.class);
            constructor.setAccessible(true);
            T subView = (T) constructor.newInstance(mContext);
            return subView;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private View _404View;
    private View _500View;
    private View _nonetView;
    private View _errorView;
}
