package com.zy.mvvmcore.base;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public abstract class BaseRepository<M extends IModel> {
    protected M mModel;
    public BaseRepository(){
        createModel();
    }

    protected abstract void createModel();
}
