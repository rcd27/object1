package com.objectone.ui.auth

import android.view.KeyEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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

    // FIXME: we should test fragments isolated from activities if possible. This can be done with FragmentScenario
    // TODO: for testing fragments, see: https://www.youtube.com/watch?v=9O1D_Ytk0xg&list=PLWz5rJ2EKKc8WFYCR9esqGGY0vOZm2l6e&linkId=59982317
    @Rule
    @JvmField
    // Given for all cases: activity starts with no Intent
    val testRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testOnFlowStart() {
        // When flow started

        // Then we see "Enter phone number" input
        onView(withContentDescription(R.string.phone_number_input))
                .check(matches(isDisplayed()))
        // Focus is on EditText
        onView(withContentDescription(R.string.phone_number_input))
                .check(matches(hasFocus()))
        // FIXME: focus is on EditText, but keyboard is hidden, wtf?
    }

    // TODO: implement
    @Test
    fun testFragmentsSwitchedAfterPhoneNumberEntered() {
        // When we type phone number
        onView(withContentDescription(R.string.phone_number_input))
                .perform(ViewActions.typeText("79858887798"))
                // And click "ENTER" button
                .perform(ViewActions.pressKey(KeyEvent.KEYCODE_ENTER))

        // Then view pager slides to another fragment
        onView(withContentDescription(R.string.enter_sms_code))
                .check(matches(isDisplayed()))
    }
}
