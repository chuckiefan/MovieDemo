package com.chuckiefan.architecturecomponentdemo.persistence.databse

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.chuckiefan.architecturecomponentdemo.BuildConfig
import com.chuckiefan.architecturecomponentdemo.model.Movie
import com.chuckiefan.architecturecomponentdemo.persistence.dao.MovieDao

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/26 17:53
 * 内容 ： 数据库类
 */
@Database(entities = arrayOf(Movie::class),version = BuildConfig.VERSION_CODE)
abstract class MovieDatabse : RoomDatabase(){

    abstract fun movieDao():MovieDao

    companion object {
        private var instance: MovieDatabse? = null
        @Synchronized
        fun get(context: Context): MovieDatabse {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        MovieDatabse::class.java, "MovieDB")
                        .build()
            }
            return instance!!
        }


    }
}