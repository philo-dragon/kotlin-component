package cn.com.topzuqiu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.topzuqiu.lib_common.utils.RouteUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_view.setOnClickListener { RouteUtil.Companion.actionStart(RouteUtil.MODULE_USER_ACTIVITY_SETTING) }
    }

}
