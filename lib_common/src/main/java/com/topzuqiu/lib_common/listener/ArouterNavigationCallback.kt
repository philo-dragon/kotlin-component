package com.topzuqiu.lib_common.listener

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback

/**
 * Created by Administrator on 2018\1\26 0026.
 */

class ArouterNavigationCallback : NavigationCallback {

    /**
     * Callback when find the destination.
     * 找到了
     * @param postcard meta
     */
    override fun onFound(postcard: Postcard) {

    }

    /**
     * Callback after lose your way.
     * 找不到了
     * @param postcard meta
     */
    override fun onLost(postcard: Postcard) {

    }

    /**
     * Callback after navigation.
     * 跳转完了
     * @param postcard meta
     */
    override fun onArrival(postcard: Postcard) {

    }

    /**
     * Callback on interrupt.
     * 被拦截了
     * @param postcard meta
     */
    override fun onInterrupt(postcard: Postcard) {

    }
}
