package com.chuckiefan.architecturecomponentdemo.utils

import android.util.Log
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/26 22:30
 * 内容 ：
 */
fun onRefreshCompleted(swipeToLoadLayout:SwipeToLoadLayout,loadMore: Boolean) {
    if (loadMore) {
        if (swipeToLoadLayout.isLoadingMore) {
            swipeToLoadLayout.isLoadingMore = false
        }
    } else {
        if (swipeToLoadLayout.isRefreshing) {
            try {
                swipeToLoadLayout.isRefreshing = false

            } catch (e: Exception) {
                Log.e("RefreshUtil", e.message)
            }

        }
    }
}