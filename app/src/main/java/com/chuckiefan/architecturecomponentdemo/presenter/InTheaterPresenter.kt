package com.chuckiefan.architecturecomponentdemo.presenter

import com.chuckiefan.architecturecomponentdemo.iview.InTheaterView
import com.chuckiefan.base.presenter.BasePresenter

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 16:15
 * 内容 ：
 */
class InTheaterPresenter(val mView:InTheaterView):BasePresenter() {
    override fun onDestroy() {
    }
}