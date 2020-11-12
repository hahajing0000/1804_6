package com.zy.mvvm.repository;

import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.mvvm.model.service.UserCenterService;
import com.zy.mvvmcore.base.BaseRepository;

import androidx.lifecycle.LiveData;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public class UserCenterRepository extends BaseRepository<UserCenterService> {
    @Override
    protected void createModel() {
        mModel=new UserCenterService();
    }

    public LiveData<UserEntity> register(UserEntity entity){
        return mModel.register(entity);
    }
}
