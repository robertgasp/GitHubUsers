package com.example.githubusers

import android.os.Build
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubusers.view.search.MainActivity
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUI() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun mainActivity_test_EditText() {
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.searchEditText)
            editText.setText("text to check", TextView.BufferType.EDITABLE)
            TestCase.assertNotNull(editText.text)
            TestCase.assertEquals("text to check", editText.text.toString())
        }
    }

    @Test
    fun mainActivity_not_null() {
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun mainActivity_isResumed() {
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun progressBar_AreVisible(){
        scenario.onActivity {
            val progressBar = it.findViewById<ProgressBar>(R.id.progressBar)
            TestCase.assertEquals(true, it.displayLoading(true))
        }
    }
}