package com.chuckiefan.architecturecomponentdemo.iview

import com.aspsine.swipetoloadlayout.OnLoadMoreListener
import com.aspsine.swipetoloadlayout.OnRefreshListener
import com.chuckiefan.base.iview.RefreshView


/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 15:59
 * 内容 ：
 */
interface TopView: RefreshView, OnLoadMoreListener, OnRefreshListener {
}