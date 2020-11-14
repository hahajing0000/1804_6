package com.zy.wiget.errorview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.zy.wiget.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2020/11/14
 */
public class ViewNoNet extends FrameLayout {
    public ViewNoNet(@NonNull Context context) {
        super(context);
        init(context);
    }


    public ViewNoNet(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewNoNet(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(Context context) {
        View subView= LayoutInflater.from(context).inflate(R.layout.view_nonet,null);
        this.addView(subView);
    }
}
