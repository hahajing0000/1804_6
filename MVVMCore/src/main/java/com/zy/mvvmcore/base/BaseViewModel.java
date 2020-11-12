package com.zy.mvvmcore.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public abstract class BaseViewModel<R extends BaseRepository> extends ViewModel implements LifecycleObserver {
    protected R mRepository;
    protected LifecycleOwner mOwner;
    public BaseViewModel(LifecycleOwner owner){
        if (owner==null){
            throw new NullPointerException("BaseViewModel owner is null...");
        }
        mOwner=owner;
        owner.getLifecycle().addObserver(this);
        createRepository();
    }

    protected abstract void createRepository();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectionView(){
        BindView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnectionView(){
        UnbindView();
    }

    protected abstract void BindView();
    protected abstract void UnbindView();
}
