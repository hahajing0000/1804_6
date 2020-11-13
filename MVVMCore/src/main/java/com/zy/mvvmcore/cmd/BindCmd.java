package com.zy.mvvmcore.cmd;

import com.zy.mvvmcore.cmd.actionfunc.Action0;
import com.zy.mvvmcore.cmd.actionfunc.Action1;
import com.zy.mvvmcore.cmd.actionfunc.Func0;

/**
 * @author:zhangyue
 * @date:2020/11/13
 */
public class BindCmd {
    private Action0 action0;
    private Action1 action1;
    private Func0 func0;

    public BindCmd(Action0 _action0){
        this.action0=_action0;
    }

    public BindCmd(Action1 _action1){
        this.action1=_action1;
    }

    public BindCmd(Func0 _func0){
        this.func0=_func0;
    }

    public void Execute(){
        this.action0.Execute();
    }

    public <T> void Execute1(T t){
        this.action1.Execute(t);
    }
}
