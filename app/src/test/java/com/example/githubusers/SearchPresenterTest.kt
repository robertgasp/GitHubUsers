package com.example.githubusers

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubusers.presenter.search.PresenterSearchContract
import com.example.githubusers.presenter.search.SearchPresenter
import com.example.githubusers.repository.GitHubRepository
import com.example.githubusers.view.search.MainActivity
import com.example.githubusers.view.search.ViewSearchContract
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk=[Build.VERSION_CODES.O_MR1])
class SearchPresenterTest {

    private lateinit var searchPresenter: PresenterSearchContract
    private var mainActivity = MainActivity

    @Before
    fun setUp(){
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity {

        }
//        searchPresenter = SearchPresenter(mainActivity)

    }

    @Test
    fun mainActivity_onAttach(){

    }

    @Test
    fun mainActivity_onDetach(){

    }

}