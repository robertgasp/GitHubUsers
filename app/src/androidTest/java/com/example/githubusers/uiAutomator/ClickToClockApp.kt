package com.example.githubusers.uiAutomator

import android.content.Context
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ClickToClockApp {

    private val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun openClock() {
        uiDevice.pressHome()
        uiDevice.swipe(1500, 700, 0, 700, 5)

        val appView = UiScrollable(UiSelector().scrollable(false))
        val clockApp = appView
            .getChildByText(UiSelector().className(TextView::class.java.name), "Clock")
        clockApp.clickAndWaitForNewWindow()

        val clockValidation = uiDevice.findObject(UiSelector().packageName("com.android.clock"))
        Assert.assertNotNull(clockValidation)

        val timer: UiObject = uiDevice.findObject(UiSelector().text("Timer"))
        timer.clickAndWaitForNewWindow()
    }
}