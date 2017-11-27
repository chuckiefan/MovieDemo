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
 * 时间 ： 2017/11/26 23:05
 * 内容 ：
 */
class CommingsoonViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = MovieRepository(app)
    private val datas = repo.getCommingsoonMovies()

    private var start:Int = 0

    fun getData() = datas.create(0, PagedList.Config.Builder()
            .setPageSize(Constant.PAGESIZE)
            .setEnablePlaceholders(Constant.ENABLE_PLACEHOLDERS)
            .build())

    fun refresh(view: RefreshView){
        start = 0
        repo.refreshCommingsoonMovies(view)
    }

    fun loadmore(view:RefreshView){
        start += Constant.PAGESIZE

        repo.loadMoreCommingsoonMovies(start,view)
    }
}