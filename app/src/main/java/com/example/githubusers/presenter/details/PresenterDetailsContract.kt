package com.example.githubusers.presenter.details

import com.example.githubusers.presenter.PresenterContract
import com.example.githubusers.view.details.ViewDetailsContract

internal interface PresenterDetailsContract : PresenterContract {
    fun onAttach(viewContract: ViewDetailsContract)
    fun onDetach(viewContract: ViewDetailsContract)
    fun setCounter(count: Int)
    fun onIncrement()
    fun onDecrement()
}
