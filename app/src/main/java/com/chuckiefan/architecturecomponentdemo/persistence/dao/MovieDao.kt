package com.chuckiefan.architecturecomponentdemo.persistence.dao

import android.arch.paging.LivePagedListProvider
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.chuckiefan.architecturecomponentdemo.model.Movie

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/26 17:50
 * 内容 ：
 */
@Dao
interface MovieDao {

    /**
     * 保存电影，冲突时替换
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(movies: List<Movie>)

    /**
     * 删除正在上映的电影
     */
    @Query("DELETE FROM Movie WHERE isInTheater")
    fun removeIntheaterMovies()

    /**
     * 删除即将上映的电影
     */
    @Query("DELETE FROM Movie WHERE isComming")
    fun removeCommingSoonMovies()

    /**
     * 删除TOP250的电影
     */
    @Query("DELETE FROM Movie WHERE isTop250")
    fun removeTop250Movies()

    /**
     * 获取正在上映的电影
     */
    @Query("SELECT * FROM Movie WHERE isInTheater")
    fun queryIntheaterMovies():LivePagedListProvider<Int,Movie>

    /**
     * 获取正在上映的电影
     */
    @Query("SELECT * FROM Movie WHERE isComming")
    fun queryCommingsoonMovies():LivePagedListProvider<Int,Movie>

    /**
     * 获取top250的电影
     */
    @Query("SELECT * FROM Movie WHERE isTop250 ORDER BY rating DESC")
    fun queryTOP250Movies():LivePagedListProvider<Int,Movie>
}