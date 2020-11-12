package com.zy.mvvm.viewmodel;

import com.zy.mvvm.model.protocol.UserEntity;
import com.zy.mvvm.repository.UserCenterRepository;
import com.zy.mvvmcore.base.BaseViewModel;

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
        mRepository.register(dataSource.getValue()).observe(mOwner, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity entity) {
                dataSource.setValue(entity);
            }
        });

    }
}
