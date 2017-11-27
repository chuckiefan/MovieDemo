package com.chuckiefan.architecturecomponentdemo.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.os.Bundle
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout
import com.chuckiefan.architecturecomponentdemo.R
import com.chuckiefan.architecturecomponentdemo.iview.TopView
import com.chuckiefan.architecturecomponentdemo.presenter.TopPresenter
import com.chuckiefan.architecturecomponentdemo.ui.adapter.MovieAdapter
import com.chuckiefan.architecturecomponentdemo.viewmodel.Top250ViewModel
import com.chuckiefan.base.ui.fragment.BaseFragment

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/23 16:02
 * 内容 ：
 */
class TopFragment : BaseFragment<TopPresenter>(),TopView{
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

    private lateinit var viewModel: Top250ViewModel
    private lateinit var swipeToLoadLayout: SwipeToLoadLayout

    private val adapter = MovieAdapter()

    override fun onError(throwable: Throwable?) {
    }

    override fun getPresenterInstance()= TopPresenter(this)

    override fun getResourceId()= R.layout.fragment_top

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

        viewModel = ViewModelProviders.of(this).get(Top250ViewModel::class.java)
        viewModel.getData().observeForever(Observer(adapter::setList))
        onRefresh()


    }

    override fun onFragmentFirstVisible() {
    }
}