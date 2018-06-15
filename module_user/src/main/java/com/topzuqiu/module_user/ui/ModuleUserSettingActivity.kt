package com.topzuqiu.module_user.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.topzuqiu.lib_common.utils.RouteUtil
import com.topzuqiu.module_user.R

@Route(path = RouteUtil.Companion.MODULE_USER_ACTIVITY_SETTING)
class ModuleUserSettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_user_activity_setting)
    }
}
