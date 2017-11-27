package com.chuckiefan.architecturecomponentdemo.net.api

import com.chuckiefan.architecturecomponentdemo.net.model.resp.MoviesResp
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/24 10:42
 * 内容 ：
 */
interface DoubanApi {

    /**
     * @param city 表示院线所在城市，可为空，如果为空则默认为北京市
     *
     * @return [MoviesResp]
     */
    @GET("v2/movie/in_theaters")
    fun retrieveInTheaters(@Query("city") city: String?): Observable<MoviesResp>

    /**
     * 即将上映的电影
     * @param start 开始，默认为0
     * @param count 每次请求数量，默认为20
     *
     * @return [MoviesResp]
     */
    @GET("v2/movie/coming_soon")
    fun retrieveComingSoon(@Query("start") start: Int?, @Query("count") count: Int?): Observable<MoviesResp>

    /**
     * Top250 评分最高的电影
     * @param start 开始，默认为0
     * @param count 每次请求数量，默认为20
     *
     * @return [MoviesResp]
     */
    @GET("v2/movie/top250")
    fun retrieveTop250(@Query("start") start: Int?, @Query("count") count: Int?): Observable<MoviesResp>


}