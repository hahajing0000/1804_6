package com.zy.mvvm.model.service;

import android.os.SystemClock;

import com.zy.mvvm.model.api.UserCenterApi;
import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.mvvmcore.base.IModel;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseRespEntity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public class UserCenterService implements IModel {

    public LiveData<BaseRespEntity<UserEntity>> register(UserEntity userEntity){
       return RetrofitFactory.getInstance().create(UserCenterApi.class).register(userEntity);
    }
}
