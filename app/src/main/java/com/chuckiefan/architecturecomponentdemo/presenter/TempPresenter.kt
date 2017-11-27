package com.chuckiefan.architecturecomponentdemo.presenter

import com.chuckiefan.architecturecomponentdemo.iview.TempView
import com.chuckiefan.base.presenter.BasePresenter

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 14:59
 * 内容 ：
 */
class TempPresenter(val mView : TempView):BasePresenter() {
    override fun onDestroy() {

    }
}