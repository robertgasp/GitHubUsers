package com.example.githubusers

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubusers.presenter.search.PresenterSearchContract
import com.example.githubusers.presenter.search.SearchPresenter
import com.example.githubusers.repository.GitHubApi
import com.example.githubusers.repository.GitHubRepository
import com.example.githubusers.view.search.MainActivity
import com.example.githubusers.view.search.ViewSearchContract
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.TestCouldNotBeSkippedException
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SearchPresenterTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var searchPresenter: SearchPresenter

    private fun createRepository(): GitHubRepository {
        return GitHubRepository(createRetrofit().create(GitHubApi::class.java))
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MainActivity.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Before
    fun setUp() {
        searchPresenter = SearchPresenter(createRepository())
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun mainActivity_onAttach() {
        searchPresenter.onAttach(MainActivity())
        scenario.onActivity {
            searchPresenter.onAttach(it)
            TestCase.assertNotNull(searchPresenter.searchPresenterViewContractForTest)
        }
    }

    @Test
    fun mainActivity_onDetach() {
        scenario.onActivity {
            if (it != null) {
                searchPresenter.onDetach(it)
                TestCase.assertEquals(null, searchPresenter.searchPresenterViewContractForTest)
            }
        }
    }

}