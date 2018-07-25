package com.topzuqiu.lib_common.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.github.anzewei.parallaxbacklayout.ViewDragHelper;
import com.github.anzewei.parallaxbacklayout.widget.ParallaxBackLayout;
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

    /**
     * 设置窗口默认背景颜色
     *
     * @return
     */
    protected int getBackgroundColorRes() {
        return R.color.lib_resource_background;
    }

    private void setContentView() {
        if (isSupportDataBinding()) {
            mBinding = DataBindingUtil.setContentView(this, getContentView());
            mBinding.getRoot().setBackgroundResource(getBackgroundColorRes());
        } else {
            getWindow().setBackgroundDrawableResource(getBackgroundColorRes());
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

    /**
     * 状态栏颜色设置
     *
     * @return
     */
    protected boolean isDrakMode() {
        return false;
    }

    /**
     * 是否支持DataBinding
     *
     * @return
     */
    private boolean isSupportDataBinding() {
        return true;
    }

    /**
     * ViewDragHelper.EDGE_BOTTOM 底部滑动
     * ViewDragHelper.EDGE_LEFT 左边滑动
     * ViewDragHelper.EDGE_TOP 顶部滑动
     * ViewDragHelper.EDGE_RIGHT 右边滑动
     *
     * @param edgeFlag
     */
    protected void setEdgeFlag(int edgeFlag) {
        ParallaxBackLayout layout = ParallaxHelper.getParallaxBackLayout(this, true);
        layout.setEdgeFlag(edgeFlag);
        layout.setEnableGesture(true);
    }

    /**
     * 禁用滑动返回
     */
    protected void disableParallaxBack() {
        ParallaxHelper.disableParallaxBack(this);
    }

    /**
     * ParallaxBackLayout.LAYOUT_COVER 抽屉模式
     * ParallaxBackLayout.LAYOUT_SLIDE 跟随模式
     * ParallaxBackLayout.LAYOUT_PARALLAX 微信视差模式
     *
     * @param mode
     */
    protected void setSlidMode(int mode) {
        ParallaxHelper.getParallaxBackLayout(this, true).setLayoutType(mode, null);
    }

    /**
     * ParallaxBackLayout.EDGE_MODE_DEFAULT 微信模式左边缘滑动返回
     * ParallaxBackLayout.EDGE_MODE_FULL 全屏返回
     *
     * @param type
     */
    protected void setSlidType(int type) {
        ParallaxHelper.getParallaxBackLayout(this, true).setEdgeMode(type);
    }

}
