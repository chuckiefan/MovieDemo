package com.chuckiefan.architecturecomponentdemo.persistence.repository

import android.content.Context
import com.chuckiefan.architecturecomponentdemo.net.retrofit.DoubanRetrofit
import com.chuckiefan.architecturecomponentdemo.persistence.dao.MovieDao
import com.chuckiefan.architecturecomponentdemo.persistence.databse.MovieDatabse
import com.chuckiefan.architecturecomponentdemo.utils.ioThread
import com.chuckiefan.base.iview.RefreshView

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/26 20:32
 * 内容 ：
 */
class MovieRepository(context: Context) {
    private val dao: MovieDao = MovieDatabse.get(context).movieDao()
    private val inTheaterMovies = dao.queryIntheaterMovies()
    private val commingsoonMovies = dao.queryCommingsoonMovies()
    private val top250Movies = dao.queryTOP250Movies()

    private val retrofit = DoubanRetrofit.get()


    /**
     * 获取正在上映的电影
     */
    fun getInTheaterMovies() = inTheaterMovies

    /**
     * 获取即将上映的电影
     */
    fun getCommingsoonMovies() = commingsoonMovies

    /**
     * 获取TOP250的电影
     */
    fun getTop250Movies() = top250Movies

    /**
     * 刷新正在上映的电影，并删除之前的数据
     */
    fun refreshInTheaterMovies(view: RefreshView){
        retrofit.inTheaterMovies()
                .subscribe({movies->
                    ioThread {
                        dao.removeIntheaterMovies()
                        dao.save(movies)
                    }
                }, { error ->
                    view.onError(error)
                    view.onRefreshCompleted()
                }, {

                    view.onRefreshCompleted()
                })
    }

    /**
     * 刷新即将上映的电影，并删除之前的数据
     */
    fun refreshCommingsoonMovies(view: RefreshView){
        retrofit.commingSoonMovies(0)
                .subscribe({movies->
                    ioThread {
                        dao.removeCommingSoonMovies()
                        dao.save(movies)
                    }
                }, { error ->
                    view.onError(error)
                    view.onRefreshCompleted()
                }, {

                    view.onRefreshCompleted()
                })
    }

    /**
     * 刷新TOP250的电影，并删除之前的数据
     */
    fun refreshTop250Movies(view:RefreshView){
        retrofit.top250Movies(0)
                .subscribe({movies->
                    ioThread {
                        dao.removeTop250Movies()
                        dao.save(movies)
                    }
                }, { error ->
                    view.onError(error)
                    view.onRefreshCompleted()
                }, {

                    view.onRefreshCompleted()
                })
    }

    /**
     * 加载更多即将上映的电影
     */
    fun loadMoreCommingsoonMovies(start:Int,view: RefreshView){
        retrofit.commingSoonMovies(start)
                .subscribe({movies->
                    ioThread {
                        dao.save(movies)
                    }
                }, { error ->
                    view.onError(error)
                    view.onLoadMoreCompleted()
                }, {

                    view.onLoadMoreCompleted()
                })
    }

    /**
     * 加载更多TOP250的电影
     */
    fun loadMoreTop250Movies(start: Int,view:RefreshView){
        retrofit.top250Movies(start)
                .subscribe({movies->
                    ioThread {
                        dao.save(movies)
                    }
                }, { error ->
                    view.onError(error)
                    view.onLoadMoreCompleted()
                }, {

                    view.onLoadMoreCompleted()
                })
    }


}