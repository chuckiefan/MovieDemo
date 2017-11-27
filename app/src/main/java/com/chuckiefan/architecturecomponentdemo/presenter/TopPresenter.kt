package com.chuckiefan.architecturecomponentdemo.presenter

import com.chuckiefan.architecturecomponentdemo.iview.TopView
import com.chuckiefan.base.presenter.BasePresenter

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 16:02
 * 内容 ：
 */
class TopPresenter(val mView:TopView):BasePresenter() {
    override fun onDestroy() {
    }
}