package com.zy.mvvm.model.service;

import android.os.SystemClock;

import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.mvvmcore.base.IModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public class UserCenterService implements IModel {

    public LiveData<UserEntity> register(UserEntity userEntity){
        //访问网络
        SystemClock.sleep(1000);
        MutableLiveData<UserEntity> data= new MutableLiveData<>();
        data.setValue(new UserEntity(0L,"小光",21,""));
        return data;
    }
}
