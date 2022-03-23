package com.example.githubusers

import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubusers.view.search.MainActivity
import com.nhaarman.mockito_kotlin.refEq
import junit.framework.TestCase
import org.junit.After
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
    fun progressBar_AreInvisible() {
        scenario.onActivity {
            val progressBar = it.findViewById<ProgressBar>(R.id.progressBar)
            TestCase.assertEquals(View.GONE, progressBar.visibility)
        }
    }

    @Test
    fun mainActivitySearchEditText_NotNull() {
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.searchEditText)
            TestCase.assertNotNull(editText)
        }
    }

    @Test
    fun mainActivityToDetailsActivityButton_NotNull() {
        scenario.onActivity {
            val toDetailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)
            TestCase.assertNotNull(toDetailsActivityButton)
        }
    }


    @Test // Проверка наличия текста в поле text на элементе "toDetailsActivityButton"
    fun mainActivityToDetailsActivityButton_HasText() {
        scenario.onActivity {
            val toDetailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)
            TestCase.assertEquals("to details", toDetailsActivityButton.text)
        }
    }

    @Test
    fun mainActivityProgressBar_NotNull() {
        scenario.onActivity {
            val progressBar = it.findViewById<ProgressBar>(R.id.progressBar)
            TestCase.assertNotNull(progressBar)
        }
    }


    @Test // Проверка наличия текста в поле hint на элементе "searchEditText"
    fun mainActivityCheckHintInEditText() {
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.searchEditText)
            TestCase.assertEquals("Enter keyword e.g. android", editText.hint)
        }
    }

    @Test
    fun mainActivityEdittext_IsVisible() {
        scenario.onActivity {
            val editText = it.findViewById<EditText>(R.id.searchEditText)
            TestCase.assertEquals(View.VISIBLE, editText.visibility)
        }
    }

    @Test
    fun mainActivityToDetailsActivityButton_IsVisible() {
        scenario.onActivity {
            val toDetailsActivityButton = it.findViewById<Button>(R.id.toDetailsActivityButton)
            TestCase.assertEquals(View.VISIBLE, toDetailsActivityButton.visibility)
        }
    }

    @Test
    fun mainActivityRecyclerView_IsVisible() {
        scenario.onActivity {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recyclerView)
            TestCase.assertEquals(View.VISIBLE, recyclerView.visibility)
        }
    }

    @After
    fun close() {
        scenario.close()
    }
}