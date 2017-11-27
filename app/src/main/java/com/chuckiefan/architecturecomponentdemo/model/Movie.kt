package com.chuckiefan.architecturecomponentdemo.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/26 16:40
 * 内容 ： 电影列表项，用于持久化
 * @param id 电影id
 * @param avatar 电影图片
 * @param title 电影名称
 * @param rating 电影评分
 * @param director 导演
 * @param casts 主演
 * @param genres 类型
 * @param year 年份
 * @param isInTheater true 正在上映
 * @param isComming true 即将上映
 * @param isTop250 true top250
 */
@Entity
data class Movie(@PrimaryKey var id: Long = 0,
                 var avatar: String? = "",
                 var title: String? = "未知", var rating: Float? = 0f, var ratingStr: String? = "(0.0)", var director: String? = "未知",
                 var casts: String? = "未知", var genres: String? = "未知", var year: String? = "未知",
                 var isInTheater: Boolean = false, var isComming: Boolean = false, var isTop250: Boolean = false)