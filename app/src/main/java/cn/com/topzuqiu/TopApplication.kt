package cn.com.topzuqiu

import android.app.Application

import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by rocky on 2018/6/13.
 */

class TopApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()//开启调试模式（如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭，否则有安全隐患）
        }
        ARouter.init(this)
    }
}
