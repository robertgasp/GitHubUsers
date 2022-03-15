package com.example.githubusers

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubusers.view.search.ViewSearchContract
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk=[Build.VERSION_CODES.O_MR1])
class SearchPresenterTest {

    private var searchPresenterViewContract: ViewSearchContract? = null

    @Before
    fun setUp(){

    }

    @Test
    fun searchPresenter_onAttach(){

    }

}