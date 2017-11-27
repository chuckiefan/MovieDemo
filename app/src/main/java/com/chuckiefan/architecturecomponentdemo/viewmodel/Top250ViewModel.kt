package com.chuckiefan.architecturecomponentdemo.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.PagedList
import com.chuckiefan.architecturecomponentdemo.Constant
import com.chuckiefan.architecturecomponentdemo.persistence.repository.MovieRepository
import com.chuckiefan.base.iview.RefreshView

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/26 23:07
 * 内容 ：
 */
class Top250ViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = MovieRepository(app)
    private val datas = repo.getTop250Movies()

    private var start:Int = 0

    fun getData() = datas.create(0, PagedList.Config.Builder()
            .setPageSize(Constant.PAGESIZE)
            .setEnablePlaceholders(Constant.ENABLE_PLACEHOLDERS)
            .build())

    fun refresh(view: RefreshView){
        start = 0

        repo.refreshTop250Movies(view)
    }

    fun loadmore(view: RefreshView){
        start += Constant.PAGESIZE

        repo.loadMoreTop250Movies(start,view)
    }
}