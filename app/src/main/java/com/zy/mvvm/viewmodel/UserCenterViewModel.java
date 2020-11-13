package com.zy.mvvm.viewmodel;

import android.util.Log;

import com.zy.common.app.AppUtils;
import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.mvvm.repository.UserCenterRepository;
import com.zy.mvvmcore.base.BaseViewModel;
import com.zy.mvvmcore.cmd.BindCmd;
import com.zy.mvvmcore.cmd.actionfunc.Action0;
import com.zy.net.protocol.resp.BaseRespEntity;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public class UserCenterViewModel extends BaseViewModel<UserCenterRepository> {
    //页面上用的数据源
    public MutableLiveData<UserEntity> dataSource=null;
    public UserCenterViewModel(LifecycleOwner owner) {
        super(owner);
        dataSource=new MutableLiveData<>();
        dataSource.setValue(new UserEntity());
    }

    public MutableLiveData<UserEntity> getDataSource() {

        return dataSource;
    }

    @Override
    protected void createRepository() {
        mRepository=new UserCenterRepository();
    }

    @Override
    protected void BindView() {

    }

    @Override
    protected void UnbindView() {

    }

    public void register(){
        mRepository.register(dataSource.getValue()).observe(mOwner, new Observer<BaseRespEntity<UserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserEntity> entity) {
                dataSource.setValue(entity.getData());
            }
        });

    }

    public BindCmd onRegisterCmd=new BindCmd(new Action0() {
        @Override
        public void Execute() {
            Log.d("123","123123");
            register();
        }
    });
}
