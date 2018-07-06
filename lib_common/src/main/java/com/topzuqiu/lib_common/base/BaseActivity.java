package com.topzuqiu.lib_common.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.topzuqiu.lib_common.R;
import com.topzuqiu.lib_common.di.AppComponent;
import com.topzuqiu.lib_common.listener.IActivity;
import com.topzuqiu.lib_common.utils.App;
import com.topzuqiu.lib_common.utils.StatusBarUtil;
import com.topzuqiu.lib_common.utils.TitleBarUtil;
import com.topzuqiu.lib_common.weidget.TitleBar;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by rocky on 2018/4/2.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends RxAppCompatActivity implements IActivity {

    protected T mBinding;
    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.mContext = this;
        super.onCreate(savedInstanceState);
        setContentView();
        drakMode();
        ARouter.getInstance().inject(this);
        componentInject(App.getInstance(BaseApplication.class).getAppComponent());
        initView();
        setToolBar();
        initData();
    }

    /**
     * 注入公共参数AppComponent
     *
     * @param appComponent
     */
    public void componentInject(AppComponent appComponent) {
    }

    /**
     * 初始化view
     */
    public void initView() {
    }

    /**
     * 设置titleBar
     */
    public void setToolBar() {
    }

    /**
     * 初始化数据
     */
    public void initData() {
    }

    protected int getBackgroundColorRes() {
        return R.color.lib_resource_background;
    }

    private void setContentView() {
        if (isSupportDataBinding()) {
            mBinding = DataBindingUtil.setContentView(this, getContentView());
            mBinding.getRoot().setBackgroundResource(getBackgroundColorRes());
        } else {
            setContentView(getContentView());
        }
    }

    private void drakMode() {
        if (isDrakMode()) {
            StatusBarUtil.darkMode(this, true);
        } else {
            StatusBarUtil.darkMode(this, false);
        }
    }

    protected void setToolBarHasBack(TitleBar titleBar) {
        TitleBarUtil.setToolBarHasBack(titleBar, getTitle().toString());
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void setToolBarNoBack(TitleBar titleBar) {
        TitleBarUtil.setToolBarNoBack(titleBar, getTitle().toString());
    }

    protected boolean isDrakMode() {
        return true;
    }

    private boolean isSupportDataBinding() {
        return true;
    }

}
