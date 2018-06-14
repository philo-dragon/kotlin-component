package com.topzuqiu.lib_common.listener;


import com.topzuqiu.lib_common.di.AppComponent;

/**
 * Activity公共函数接口
 * 按方法书写顺序执行
 */
public interface IActivity {


    int getContentView();

    void componentInject(AppComponent appComponent);

    void initView();

    void setToolBar();

    void initData();

}
