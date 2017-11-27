package com.chuckiefan.architecturecomponentdemo.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout
import com.chuckiefan.architecturecomponentdemo.R
import com.chuckiefan.architecturecomponentdemo.iview.FutureView
import com.chuckiefan.architecturecomponentdemo.presenter.FuturePresenter
import com.chuckiefan.architecturecomponentdemo.ui.adapter.MovieAdapter
import com.chuckiefan.architecturecomponentdemo.viewmodel.CommingsoonViewModel
import com.chuckiefan.base.ui.fragment.BaseFragment

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 16:02
 * 内容 ：
 */
class FutureFragment : BaseFragment<FuturePresenter>(),FutureView{
    override fun onLoadMoreCompleted() {
        com.chuckiefan.architecturecomponentdemo.utils.onRefreshCompleted(swipeToLoadLayout,true)
    }

    override fun onRefreshCompleted() {
        com.chuckiefan.architecturecomponentdemo.utils.onRefreshCompleted(swipeToLoadLayout,false)
    }

    override fun onLoadMore() {
        viewModel.loadmore(this)
    }

    override fun onRefresh() {
        viewModel.refresh(this)
    }

    private lateinit var viewModel: CommingsoonViewModel
    private lateinit var swipeToLoadLayout: SwipeToLoadLayout

    private val adapter = MovieAdapter()

    override fun onError(throwable: Throwable?) {
    }

    override fun getPresenterInstance()= FuturePresenter(this)

    override fun getResourceId()= R.layout.fragment_future

    override fun initView(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.swipe_target)
        swipeToLoadLayout = view.findViewById(R.id.swipeToLoadLayout)
        swipeToLoadLayout.setOnLoadMoreListener(this)
        swipeToLoadLayout.setOnRefreshListener(this)

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CommingsoonViewModel::class.java)
        viewModel.getData().observeForever(Observer(adapter::setList))
        onRefresh()


    }

    override fun onFragmentFirstVisible() {
    }
}