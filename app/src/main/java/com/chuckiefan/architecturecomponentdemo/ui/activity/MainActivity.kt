package com.chuckiefan.architecturecomponentdemo.ui.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.chuckiefan.architecturecomponentdemo.R
import com.chuckiefan.architecturecomponentdemo.iview.MainView
import com.chuckiefan.architecturecomponentdemo.presenter.MainPresenter
import com.chuckiefan.base.ui.activity.BaseActivity
import com.ogaclejapan.smarttablayout.SmartTabLayout

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 14:55
 * 内容 ：
 */
class MainActivity : BaseActivity<MainPresenter>(),MainView{
    override fun onError(throwable: Throwable?) {
    }

    override fun getContentViewId()= R.layout.activity_main

    override fun getPresenterInstance()= MainPresenter(this)

    override fun getTitleResId() = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val smartTabLayout: SmartTabLayout = findViewById(R.id.smart_tab_layout) //as SmartTabLayout
        val viewPager: ViewPager = findViewById(R.id.view_pager)// as ViewPager
        presenter?.initTabs(this, smartTabLayout, viewPager)
    }
}