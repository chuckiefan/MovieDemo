package com.chuckiefan.architecturecomponentdemo.ui.fragment

import android.view.View
import com.chuckiefan.architecturecomponentdemo.R
import com.chuckiefan.architecturecomponentdemo.iview.TempView
import com.chuckiefan.architecturecomponentdemo.presenter.TempPresenter
import com.chuckiefan.base.ui.fragment.BaseFragment

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 15:00
 * 内容 ：
 */
class TempFragment: BaseFragment<TempPresenter>(),TempView {
    override fun onError(throwable: Throwable?) {
    }

    override fun getPresenterInstance()= TempPresenter(this)

    override fun getResourceId()= R.layout.fragment_temp

    override fun initView(view: View) {
    }

    override fun onFragmentFirstVisible() {
    }
}