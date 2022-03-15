package com.example.githubusers.presenter.search

import com.example.githubusers.model.SearchResponse
import com.example.githubusers.repository.GitHubRepository
import com.example.githubusers.view.ViewContract
import com.example.githubusers.view.search.ViewSearchContract
import retrofit2.Response

internal class SearchPresenter internal constructor(
//    private val viewContract: ViewSearchContract,
    private val repository: GitHubRepository
) : PresenterSearchContract, GitHubRepository.GitHubRepositoryCallback {

    private var searchPresenterViewContract: ViewSearchContract? = null

    override fun onAttach(viewContract: ViewSearchContract) {
        this.searchPresenterViewContract = viewContract
    }

    override fun onDetach(viewContract: ViewSearchContract) {
        searchPresenterViewContract = viewContract

        searchPresenterViewContract = null
    }

    override fun searchGitHub(searchQuery: String) {
        searchPresenterViewContract?.displayLoading(true)
        repository.searchGithub(searchQuery, this)
    }

    override fun handleGitHubResponse(response: Response<SearchResponse?>?) {
        searchPresenterViewContract?.displayLoading(false)
        if (response != null && response.isSuccessful) {
            val searchResponse = response.body()
            val searchResults = searchResponse?.searchResults
            val totalCount = searchResponse?.totalCount
            if (searchResults != null && totalCount != null) {
                searchPresenterViewContract?.displaySearchResults(
                    searchResults,
                    totalCount
                )
            } else {
                searchPresenterViewContract?.displayError("Search results or total count are null")
            }
        } else {
            searchPresenterViewContract?.displayError("Response is null or unsuccessful")
        }
    }

    override fun handleGitHubError() {
        searchPresenterViewContract?.displayLoading(false)
        searchPresenterViewContract?.displayError()
    }
}
