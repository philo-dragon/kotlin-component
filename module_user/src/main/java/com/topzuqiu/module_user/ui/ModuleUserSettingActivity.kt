package com.topzuqiu.module_user.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.topzuqiu.lib_common.base.BaseActivity
import com.topzuqiu.lib_common.di.AppComponent
import com.topzuqiu.lib_common.utils.RouteUtil
import com.topzuqiu.module_user.R
import com.topzuqiu.module_user.databinding.ModuleUserActivitySettingBinding

@Route(path = RouteUtil.Companion.MODULE_USER_ACTIVITY_SETTING)
class ModuleUserSettingActivity : BaseActivity<ModuleUserActivitySettingBinding>() {
    override fun getContentView(): Int {
        return R.layout.module_user_activity_setting
    }

    override fun componentInject(appComponent: AppComponent?) {
    }

    override fun initView() {
    }

    override fun setToolBar() {
    }

    override fun initData() {
    }

}
