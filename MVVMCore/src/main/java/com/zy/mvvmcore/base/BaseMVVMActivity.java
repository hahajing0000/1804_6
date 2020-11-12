package com.zy.mvvmcore.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.database.DatabaseUtilsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author:zhangyue
 * @date:2020/11/12
 */
public abstract class BaseMVVMActivity<V extends ViewDataBinding,VM extends BaseViewModel> extends BaseActivity {
    protected V binding;
    protected VM viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        initViewDataBinding();
        initObservable();
        super.onCreate(savedInstanceState);
    }

    private void initViewDataBinding() {
        binding= DataBindingUtil.setContentView(this,getLayoutId());
        binding.setVariable(getVariable(),viewModel=createViewModel());
    }

    /**
     * 刷新页面数据
     */
    public void refresh(){
        if (viewModel!=null){
            binding.setVariable(getVariable(),viewModel);
        }
    }

    protected abstract int getVariable();

    protected abstract VM createViewModel();

    protected abstract int getLayoutId();
    protected abstract void initObservable();
}
