package com.chuckiefan.architecturecomponentdemo.presenter

import com.chuckiefan.architecturecomponentdemo.iview.FutureView
import com.chuckiefan.base.presenter.BasePresenter

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 16:14
 * 内容 ：
 */
class FuturePresenter(val mView:FutureView):BasePresenter() {
    override fun onDestroy() {
    }
}