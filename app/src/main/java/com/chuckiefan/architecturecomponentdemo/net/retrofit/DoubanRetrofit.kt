package com.chuckiefan.architecturecomponentdemo.net.retrofit

import com.chuckiefan.architecturecomponentdemo.Constant
import com.chuckiefan.architecturecomponentdemo.model.Movie
import com.chuckiefan.architecturecomponentdemo.net.api.DoubanApi
import com.chuckiefan.architecturecomponentdemo.net.model.resp.Subject
import com.chuckiefan.base.net.converter.JacksonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/24 14:44
 * 内容 ：
 */
class DoubanRetrofit {
    private val TAG: String = this.javaClass.simpleName
    private val PAGESIZE = Constant.PAGESIZE//20

    companion object {
        private val API = buildAPI()

        private fun buildAPI(): DoubanApi {
            return Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create())
                    .baseUrl(Constant.url)// "http://api.douban.com/"
                    .build()
                    .create(DoubanApi::class.java)
        }

        private var instance: DoubanRetrofit? = null

        @Synchronized
        fun get(): DoubanRetrofit {
            if (null == instance) {
                instance = DoubanRetrofit()
            }
            return instance!!
        }


    }

    /**
     * 正在上映
     */
    fun inTheaterMovies(): Observable<List<Movie>> {

        return API.retrieveInTheaters(null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .concatMap({ origin ->
                    Observable.just(origin.subjects)
                }).map({ subjects ->
            convert(subjects, true, false, false)
        })
    }


    /**
     * 即将上映
     * @param start 开始位置
     */
    fun commingSoonMovies(start: Int): Observable<List<Movie>> {

        return API.retrieveComingSoon(start, PAGESIZE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .concatMap({ origin ->
                    Observable.just(origin.subjects)
                }).map({ subjects ->
            convert(subjects, false, true, false)
        })

    }

    /**
     * 评分top250电影
     * @param start 开始位置
     */
    fun top250Movies(start: Int): Observable<List<Movie>> {
        return API.retrieveTop250(start, PAGESIZE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .concatMap({ origin ->
                    Observable.just(origin.subjects)
                }).map({ subjects ->
            convert(subjects, false, false, true)
        })
    }

    /**
     * [Subject]列表转为[Movie]列表
     */
    private fun convert(subjects: List<Subject>, isInTheater: Boolean, isComming: Boolean, isTop250: Boolean): List<Movie> {
        val movies: List<Movie> = subjects.map { item ->
            //评分
            val rating: Float
            val ratingStr: String
            if (null == item.rating) {
                ratingStr = "(0.0)"
                rating = 0.0f

            } else {
                rating = (item.rating.average / 2).toFloat()
                ratingStr = "(${item.rating.average})"
            }

            //导演
            val directors: String = if (null == item.directors) {
                ""
            } else {
                item.directors.joinToString("/","","",-1,"...",{it ->
                    it.name
                })
            }

            //主演
            val casts = if (null == item.casts) {
                ""
            } else {
                item.casts.joinToString("/","","",-1,"...",{it ->
                    it.name
                })
            }

            //类型
            val genres = if (null == item.genres) {
                ""
            } else {
                item.genres.joinToString("/","","",-1,"...")
            }


            val movie = Movie(item.id.toLong()
                    , item.images.medium, item.title, rating, ratingStr, directors, casts, genres,
                    item.year, isInTheater, isComming, isTop250)
            movie

        }
        return movies
    }


}