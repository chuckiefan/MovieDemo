package com.chuckiefan.architecturecomponentdemo

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 14:24
 * 内容 ：
 */
class App : Application(){
    val TAG: String = "App"
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}