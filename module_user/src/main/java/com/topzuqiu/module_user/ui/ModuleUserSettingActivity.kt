package com.topzuqiu.module_user.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.github.anzewei.parallaxbacklayout.ParallaxBack
import com.topzuqiu.lib_common.base.BaseActivity
import com.topzuqiu.lib_common.utils.RouteUtil
import com.topzuqiu.module_user.R
import com.topzuqiu.module_user.databinding.ModuleUserActivitySettingBinding

@ParallaxBack(edge = ParallaxBack.Edge.TOP, layout = ParallaxBack.Layout.PARALLAX)
@Route(path = RouteUtil.Companion.MODULE_USER_ACTIVITY_SETTING)
class ModuleUserSettingActivity : BaseActivity<ModuleUserActivitySettingBinding>() {
    override fun getContentView(): Int {
        return R.layout.module_user_activity_setting
    }
}
