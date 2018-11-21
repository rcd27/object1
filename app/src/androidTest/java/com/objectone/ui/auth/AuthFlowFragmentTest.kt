package com.objectone.ui.auth

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.objectone.R
import com.objectone.ui.MainActivity
import org.junit.Rule
import org.junit.Test

@LargeTest
class AuthFlowFragmentTest {

    // FIXME: we should test fragments isolated from activities if possible
    @Rule
    @JvmField
    val testRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testOnFlowStart() {
        // When flow started

        // Then we see "Enter phone number" input
        onView(withContentDescription(R.string.phone_number_input)).check(matches(isDisplayed()))
        // Focus is on EditText
        onView(withContentDescription(R.string.phone_number_input)).check(matches(hasFocus()))
        // FIXME: focus is on EditText, but keyboard is hidden, wtf?
    }
}