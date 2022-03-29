package com.example.githubusers.uiAutomator

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ToDetailsActivityButtonsTest {

    private val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    private val context = ApplicationProvider.getApplicationContext<Context>()

    private val packageName = context.packageName

    @Before
    fun setup() {
        uiDevice.pressHome()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        uiDevice.wait(Until.hasObject(By.res(packageName)), TIMEOUT)
        val btnToDetails = uiDevice.findObject(By.res(packageName, "toDetailsActivityButton"))
        btnToDetails.click()

        uiDevice.wait(Until.findObject(By.res(packageName, "totalCountTextView")), TIMEOUT)
    }

    @Test
    fun detailsActivity_isCreated() {
        val totalCountTextView = uiDevice.findObject(By.res(packageName, "totalCountTextView"))
        Assert.assertNotNull(totalCountTextView)
        Assert.assertEquals(totalCountTextView.text.toString(), "Number of results: 0")
    }

    @Test
    fun detailsActivity_check_btnIncrement() {
        val totalCountTextView = uiDevice.findObject(By.res(packageName, "totalCountTextView"))
        val btnIncrement = uiDevice.findObject(By.res(packageName, "incrementButton"))
        btnIncrement.click()
        Assert.assertEquals(totalCountTextView.text.toString(), "Number of results: 1")
    }

    @Test
    fun detailsActivity_check_btnDecrement() {
        val totalCountTextView = uiDevice.findObject(By.res(packageName, "totalCountTextView"))
        val btnDecrement = uiDevice.findObject(By.res(packageName, "decrementButton"))
        btnDecrement.click()
        Assert.assertEquals(totalCountTextView.text.toString(), "Number of results: -1")
    }

    companion object {
        private const val TIMEOUT = 5000L
    }
}