package com.topzuqiu.module_user.ui.activitys

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ScreenUtils
import com.github.anzewei.parallaxbacklayout.ParallaxBack
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import com.scwang.smartrefresh.layout.util.DensityUtil
import com.topzuqiu.lib_common.base.BaseActivity
import com.topzuqiu.lib_common.utils.RouteUtil
import com.topzuqiu.lib_common.utils.StatusBarUtil
import com.topzuqiu.module_user.R
import com.topzuqiu.module_user.databinding.ModuleUserActivitySettingBinding
import com.topzuqiu.module_user.ui.framents.*
import kotlinx.android.synthetic.main.module_user_activity_setting.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import java.util.*


@ParallaxBack(edge = ParallaxBack.Edge.LEFT, layout = ParallaxBack.Layout.PARALLAX, edgeMode = ParallaxBack.EdgeMode.FULLSCREEN)
@Route(path = RouteUtil.Companion.MODULE_USER_ACTIVITY_SETTING)
class ModuleUserSettingActivity : BaseActivity<ModuleUserActivitySettingBinding>() {

    var toolBarPositionY = 0
    var mOffset = 0
    var mScrollY = 0

    val mTitles = arrayOf("动态", "文章", "问答")
    val mDataList = Arrays.asList<String>(*mTitles)

    override fun getContentView(): Int {
        return R.layout.module_user_activity_setting
    }

    fun initFragment() {
        var fragments = arrayListOf<Fragment>(ArticleFragment(), DynamicFragment(), QuestionFragment())
        var fragmentAdapter = ComFragmentAdapter(supportFragmentManager, fragments)
        mBinding.viewPager.adapter = fragmentAdapter
    }

    override fun initView() {
        StatusBarUtil.immersive(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)
        refreshLayout.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onHeaderPulling(header: RefreshHeader?, percent: Float, offset: Int, bottomHeight: Int, extendHeight: Int) {
                mOffset = offset / 2
                mBinding.ivHeader.setTranslationY((mOffset - mScrollY).toFloat())
                toolbar.alpha = 1 - Math.min(percent, 1f)
            }

            override fun onHeaderReleasing(header: RefreshHeader?, percent: Float, offset: Int, bottomHeight: Int, extendHeight: Int) {
                mOffset = offset / 2
                mBinding.ivHeader.setTranslationY((mOffset - mScrollY).toFloat())
            }
        })

        toolbar.post { dealWithViewPager() }

        scrollView.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
            internal var lastScrollY = 0
            internal var h = DensityUtil.dp2px(170f)
            internal var color = ContextCompat.getColor(applicationContext, R.color.mainWhite) and 0x00ffffff

            override fun onScrollChange(v: NestedScrollView, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
                var scrollY = scrollY
                val location = IntArray(2)
                mBinding.magicIndicator.getLocationOnScreen(location)
                val yPosition = location[1]
                if (yPosition < toolBarPositionY) {
                    mBinding.magicIndicatorTitle.setVisibility(View.VISIBLE)
                    scrollView.setNeedScroll(false)
                } else {
                    mBinding.magicIndicatorTitle.setVisibility(View.GONE)
                    scrollView.setNeedScroll(true)

                }

                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY)
                    mScrollY = if (scrollY > h) h else scrollY
                    buttonBarLayout.alpha = 1f * mScrollY / h
                    toolbar.setBackgroundColor(255 * mScrollY / h shl 24 or color)
                    mBinding.ivHeader.setTranslationY((mOffset - mScrollY).toFloat())
                }
                if (scrollY == 0) {
                    mBinding.ivBack.setImageResource(R.drawable.back_white)
                    mBinding.ivMenu.setImageResource(R.drawable.icon_menu_white)
                } else {
                    mBinding.ivBack.setImageResource(R.drawable.back_black)
                    mBinding.ivMenu.setImageResource(R.drawable.icon_menu_black)
                }

                lastScrollY = scrollY
            }
        })

        buttonBarLayout.alpha = 0f
        toolbar.setBackgroundColor(0)
        initFragment()
        initMagicIndicator()
        initMagicIndicatorTitle()
    }

    private fun dealWithViewPager() {
        toolBarPositionY = toolbar.height
        val params = mBinding.viewPager.getLayoutParams()
        params.height = ScreenUtils.getScreenHeight() - toolBarPositionY - mBinding.magicIndicator.height + 1
        mBinding.viewPager.setLayoutParams(params)
    }

    private fun initMagicIndicator() {
        val commonNavigator = CommonNavigator(this)
        commonNavigator.scrollPivotX = 0.65f
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return if (mDataList == null) 0 else mDataList.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val simplePagerTitleView = ColorFlipPagerTitleView(context)
                simplePagerTitleView.setText(mDataList.get(index))
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(this@ModuleUserSettingActivity, R.color.mainBlack))
                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(this@ModuleUserSettingActivity, R.color.mainBlack))
                simplePagerTitleView.setTextSize(16f)
                simplePagerTitleView.setOnClickListener(View.OnClickListener { mBinding.viewPager.setCurrentItem(index, false) })
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                indicator.mode = LinePagerIndicator.MODE_EXACTLY
                indicator.lineHeight = UIUtil.dip2px(context, 2.0).toFloat()
                indicator.lineWidth = UIUtil.dip2px(context, 20.0).toFloat()
                indicator.roundRadius = UIUtil.dip2px(context, 3.0).toFloat()
                indicator.startInterpolator = AccelerateInterpolator()
                indicator.endInterpolator = DecelerateInterpolator(2.0f)
                indicator.setColors(ContextCompat.getColor(this@ModuleUserSettingActivity, R.color.mainRed))
                return indicator
            }
        }
        mBinding.magicIndicator.setNavigator(commonNavigator)
        ViewPagerHelper.bind(mBinding.magicIndicator, mBinding.viewPager)
    }

    private fun initMagicIndicatorTitle() {
        val commonNavigator = CommonNavigator(this)
        commonNavigator.scrollPivotX = 0.65f
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return mDataList?.size ?: 0
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val simplePagerTitleView = ColorFlipPagerTitleView(context)
                simplePagerTitleView.text = mDataList[index]
                simplePagerTitleView.normalColor = ContextCompat.getColor(this@ModuleUserSettingActivity, R.color.mainBlack)
                simplePagerTitleView.selectedColor = ContextCompat.getColor(this@ModuleUserSettingActivity, R.color.mainBlack)
                simplePagerTitleView.textSize = 16f
                simplePagerTitleView.setOnClickListener { mBinding.viewPager.setCurrentItem(index, false) }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                indicator.mode = LinePagerIndicator.MODE_EXACTLY
                indicator.lineHeight = UIUtil.dip2px(context, 2.0).toFloat()
                indicator.lineWidth = UIUtil.dip2px(context, 20.0).toFloat()
                indicator.roundRadius = UIUtil.dip2px(context, 3.0).toFloat()
                indicator.startInterpolator = AccelerateInterpolator()
                indicator.endInterpolator = DecelerateInterpolator(2.0f)
                indicator.setColors(ContextCompat.getColor(this@ModuleUserSettingActivity, R.color.mainRed))
                return indicator
            }
        }
        mBinding.magicIndicatorTitle.setNavigator(commonNavigator)
        ViewPagerHelper.bind(mBinding.magicIndicatorTitle, mBinding.viewPager)

    }

}
