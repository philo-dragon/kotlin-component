package com.topzuqiu.lib_common.utils

import android.content.Context
import android.support.v4.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.RuntimeException
import java.util.*

/**
 * Aroute 跳转工具类
 */
class RouteUtil {

    companion object {

        const val MODULE_USER_ACTIVITY_SETTING = "/module_user/module_user_activity_setting"

        /**
         * 启动Activity
         * parameters 携带参数
         *
         * @param path
         */
        @JvmOverloads
        fun actionStart(path: String, parameters: Map<String, String> = HashMap()) {
            val build = ARouter.getInstance().build(path)

            for ((key, value) in parameters) {
                build.withString(key, value)
            }

            build.navigation()
        }

        /**
         * 启动Activity
         * parameters 携带参数
         * enterId 进入动画
         * exitId 退出动画
         *
         * @param path
         */
        @JvmOverloads
        fun actionStart(context: Context, path: String, enterId: Int, exitId: Int, parameters: Map<String, String> = HashMap()) {
            val build = ARouter.getInstance().build(path)
            for ((key, value) in parameters) {
                build.withString(key, value)
            }
            build.withTransition(enterId, exitId)
            build.navigation(context)
        }


        /**
         * 获取Fragment
         * parameters 携带参数
         *
         * @param path
         */
        @JvmOverloads
        fun newFragment(path: String, parameters: Map<String, String> = HashMap()): Fragment {
            val build = ARouter.getInstance().build(path)

            for ((key, value) in parameters) {
                build.withString(key, value)
            }

            return build.navigation() as? Fragment ?: throw RuntimeException("path is not Fragment")
        }

    }

}
