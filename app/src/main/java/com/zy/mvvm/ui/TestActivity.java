package com.zy.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zy.mvvm.NetWorkBroadcastReceiver;
import com.zy.mvvm.R;
import com.zy.wiget.ContainerLayout;
import com.zy.wiget.errorview.ContainerState;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    private ContainerLayout clMain;
    private Button btn404;
    private Button btn500;
    private Button btnNonet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        clMain = (ContainerLayout) findViewById(R.id.cl_main);

        btn404 = (Button) findViewById(R.id.btn_404);
        btn500 = (Button) findViewById(R.id.btn_500);
        btnNonet = (Button) findViewById(R.id.btn_nonet);

        btn404.setOnClickListener(this);
        btn500.setOnClickListener(this);
        btnNonet.setOnClickListener(this);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(new NetWorkBroadcastReceiver(),intentFilter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_404:
                clMain.ChangeWrongView(ContainerState._404);
                break;
            case R.id.btn_500:
                clMain.ChangeWrongView(ContainerState._500);
                break;
            case R.id.btn_nonet:
                clMain.ChangeWrongView(ContainerState.NONET);
                break;
        }
    }
}