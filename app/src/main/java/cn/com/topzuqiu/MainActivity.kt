package cn.com.topzuqiu

import android.content.Intent
import android.content.pm.ActivityInfo
import cn.com.topzuqiu.databinding.ActivityMainBinding
import com.topzuqiu.lib_common.base.BaseActivity
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.filter.Filter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tv_view.setOnClickListener {
            Matisse.from(this@MainActivity)
                    .choose(MimeType.ofAll())
                    .countable(true)
                    .maxSelectable(9)
                    .gridExpectedSize(300)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(GlideEngine())
                    .forResult(111)

            //RouteUtil.Companion.actionStart(RouteUtil.MODULE_USER_ACTIVITY_SETTING)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == RESULT_OK) {
            //mMatisse.obtainResult(data)
        }
    }

}
