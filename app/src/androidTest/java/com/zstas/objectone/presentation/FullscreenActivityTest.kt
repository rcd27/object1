package com.zstas.objectone.presentation

import androidx.annotation.Keep
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import com.zstas.objectone.R

@Keep
class FullscreenActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(FullscreenActivity::class.java)

    @Test
    fun buttonIsDisplayedAfterTap() {
        // Given that when activity starts we see "Dummy content" text
        onView(withId(R.id.fullscreen_content)).check(matches(isDisplayed()))

        // When tap the screen
        onView(withId(R.id.fullscreen_content)).perform(click())

        waitTime()

        // Then check that button has appeared
        onView(withId(R.id.dummy_button)).check(matches(isDisplayed()))
    }

    private fun waitTime() {
        val idlingResource = ElapsedTimeIdlingResource(500)
        val registry = IdlingRegistry.getInstance()
        registry.register(idlingResource)
    }

    private class ElapsedTimeIdlingResource(val waitingTime: Long) : IdlingResource {
        lateinit var resourceCallback: IdlingResource.ResourceCallback

        override fun getName(): String {
            return ElapsedTimeIdlingResource::class.java.simpleName + ":" + waitingTime
        }

        private val startTime: Long = System.currentTimeMillis()

        override fun isIdleNow(): Boolean {
            val elapsed = System.currentTimeMillis() - startTime
            val idle = (elapsed >= waitingTime)
            if (idle) {
                resourceCallback.onTransitionToIdle()
            }
            return idle
        }

        override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
            this.resourceCallback = callback!!
        }
    }
}