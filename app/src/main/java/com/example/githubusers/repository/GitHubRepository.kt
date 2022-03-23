package com.example.githubusers.repository

import com.example.githubusers.model.SearchResponse
import com.example.githubusers.presenter.RepositoryContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class GitHubRepository(private val gitHubApi: GitHubApi) : RepositoryContract {

//    fun searchGithub(
//        query: String,
//        callback: GitHubRepositoryCallback
//    ) {
//        val call = gitHubApi.searchGithub(query)
//        call?.enqueue(object : Callback<SearchResponse?> {
//
//            override fun onResponse(
//                call: Call<SearchResponse?>,
//                response: Response<SearchResponse?>
//            ) {
//                callback.handleGitHubResponse(response)
//            }
//
//            override fun onFailure(
//                call: Call<SearchResponse?>,
//                t: Throwable
//            ) {
//                callback.handleGitHubError()
//            }
//        })
//    }
//
//    interface GitHubRepositoryCallback {
//        fun handleGitHubResponse(response: Response<SearchResponse?>?)
//        fun handleGitHubError()
//    }

    override fun searchGithub(query: String, callback: RepositoryCallback) {
        val call = gitHubApi.searchGithub(query)
        call?.enqueue(object : Callback<SearchResponse?> {

            override fun onResponse(
                call: Call<SearchResponse?>,
                response: Response<SearchResponse?>
            ) {
                callback.handleGitHubResponse(response)
            }

            override fun onFailure(
                call: Call<SearchResponse?>,
                t: Throwable
            ) {
                callback.handleGitHubError()
            }
        })
    }
}
