package com.example.githubusers.presenter.details

import android.content.Context
import com.example.githubusers.view.details.DetailsActivity
import com.example.githubusers.view.details.ViewDetailsContract
import com.example.githubusers.view.search.ViewSearchContract

internal class DetailsPresenter internal constructor(
//    private val viewContract: ViewDetailsContract,
    private var count: Int = 0
) : PresenterDetailsContract {

    private var thisViewContract: ViewDetailsContract? = null

    override fun onAttach(viewContract: ViewDetailsContract) {
        this.thisViewContract = viewContract
    }

    override fun onDetach(viewContract: ViewDetailsContract) {
        this.thisViewContract = viewContract
        thisViewContract = null
    }

    override fun setCounter(count: Int) {
        if (thisViewContract != null) {
            this.count = count
        }
    }

    override fun onIncrement() {
        count++
        thisViewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        thisViewContract?.setCount(count)
    }

}