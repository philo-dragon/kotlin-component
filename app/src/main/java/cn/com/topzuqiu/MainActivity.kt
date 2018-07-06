package cn.com.topzuqiu

import cn.com.topzuqiu.databinding.ActivityMainBinding
import com.topzuqiu.lib_common.base.BaseActivity
import com.topzuqiu.lib_common.di.AppComponent
import com.topzuqiu.lib_common.utils.RouteUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tv_view.setOnClickListener { RouteUtil.Companion.actionStart(RouteUtil.MODULE_USER_ACTIVITY_SETTING) }
    }

}
