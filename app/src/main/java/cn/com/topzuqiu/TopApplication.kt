package cn.com.topzuqiu

import com.github.anzewei.parallaxbacklayout.ParallaxHelper
import com.topzuqiu.lib_common.base.BaseApplication

/**
 * Created by rocky on 2018/6/13.
 */
class TopApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance())
    }
}
