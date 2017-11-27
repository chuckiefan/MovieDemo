package com.chuckiefan.architecturecomponentdemo.presenter

import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import com.chuckiefan.architecturecomponentdemo.iview.MainView
import com.chuckiefan.architecturecomponentdemo.ui.activity.MainActivity
import com.chuckiefan.architecturecomponentdemo.ui.fragment.FutureFragment
import com.chuckiefan.architecturecomponentdemo.ui.fragment.InTheaterFragment
import com.chuckiefan.architecturecomponentdemo.ui.fragment.TempFragment
import com.chuckiefan.architecturecomponentdemo.ui.fragment.TopFragment
import com.chuckiefan.base.presenter.BasePresenter
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 14:54
 * 内容 ：
 */
class MainPresenter(val mView: MainView) : BasePresenter(){

    override fun onDestroy() {
    }

    fun initTabs(context: MainActivity, smartTabLayout: SmartTabLayout, viewPager: ViewPager) {
        val adapter = FragmentPagerItemAdapter(
                context.supportFragmentManager, FragmentPagerItems.with(context)
                .add("正在上映", InTheaterFragment::class.java)
                .add("即将上映", FutureFragment::class.java)
                .add("Top250", TopFragment::class.java)
                .create())
        viewPager.offscreenPageLimit = 3
        viewPager.adapter = adapter



        smartTabLayout.setViewPager(viewPager)
    }
}