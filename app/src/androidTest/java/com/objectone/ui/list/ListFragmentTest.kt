package com.objectone.ui.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.rule.ActivityTestRule
import com.objectone.ui.MainActivity
import com.objectone.util.ElapsedTimeIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListFragmentTest {
    @Rule
    @JvmField
    val mainActivityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    fun setUp() {
        mainActivityTestRule.launchActivity(null)
        mainActivityTestRule.activity.supportFragmentManager.beginTransaction().add(ListFragment.newInstance(), "").commit()
    }

    @After
    fun reset() {
        mainActivityTestRule.finishActivity()
    }

    // FIXME:
    @Test
    fun dummyTestCase() {
        // Activity started with no Intent

        // When we switch to ListFragment

        // TODO: would be nice to have something like:
        // runWithIdlingResource(1000) {
        //      onView(ViewMatchers.withContentDescription("1")).check(matches(isDisplayed()))
        // }
        // Where registering and unregistering would be in the block

        // Wait
        IdlingRegistry.getInstance().register(ElapsedTimeIdlingResource(1000))

        // Then we see some card views
        onView(ViewMatchers.withContentDescription("1")).check(matches(isDisplayed()))
    }
}