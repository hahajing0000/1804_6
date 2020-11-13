package com.zy.mvvmcore.cmd.actionfunc;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public interface Func1<T,R> {
    R Execute(T t);
}
