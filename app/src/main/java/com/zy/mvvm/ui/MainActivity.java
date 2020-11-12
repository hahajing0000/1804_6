package com.zy.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;

import com.zy.mvvm.R;
import com.zy.mvvm.databinding.ActivityMainBinding;
import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.mvvm.viewmodel.UserCenterViewModel;
import com.zy.mvvmcore.base.BaseMVVMActivity;

public class MainActivity extends BaseMVVMActivity<ActivityMainBinding, UserCenterViewModel> {


    @Override
    protected void initData() {
        binding.setHandlers(this);
    }

    @Override
    protected int getVariable() {
        return BR.test;
    }

    @Override
    protected UserCenterViewModel createViewModel() {
        return new UserCenterViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initObservable() {
        viewModel.getDataSource().observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                showMsg(userEntity.toString());
            }
        });
    }


    public void onLoginClick(View view){
        viewModel.register();
    }
}