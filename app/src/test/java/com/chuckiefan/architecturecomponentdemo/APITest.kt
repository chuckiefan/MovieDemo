package com.chuckiefan.architecturecomponentdemo

import com.chuckiefan.architecturecomponentdemo.net.api.DoubanApi
import com.chuckiefan.base.net.converter.JacksonConverterFactory
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/24 11:31
 * 内容 ：
 */
class APITest {
    lateinit var api: DoubanApi

    @Before
    fun prepare() {
        api = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("http://api.douban.com/")
                .build()
                .create(DoubanApi::class.java)
    }

    @Test
    fun testInTheatears() {
        api.retrieveInTheaters(null)
                .subscribe({data->
                    Assert.assertNotNull(data)
                }, {error->
                    Assert.fail()
                }, {

                })
    }
}