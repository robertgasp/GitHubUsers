package com.example.githubusers.presenter.search

import com.example.githubusers.presenter.PresenterContract
import com.example.githubusers.view.search.ViewSearchContract

internal interface PresenterSearchContract : PresenterContract {
    fun onAttach(viewContract: ViewSearchContract)
    fun onDetach(viewContract: ViewSearchContract)
    fun searchGitHub(searchQuery: String)

}