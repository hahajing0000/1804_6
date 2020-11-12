package com.zy.mvvmcore.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected void startActivity(Class<?> target){
        startActivity(new Intent(this,target));
    }

    protected void startActivity(Class<?> target,Bundle bundle){
        Intent intent=new Intent(this,target);
        intent.putExtra("params",bundle);
        startActivity(intent);
    }

    protected void showMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    protected void showLongMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
