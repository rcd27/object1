package com.objectone.util

import androidx.test.espresso.IdlingResource

class ElapsedTimeIdlingResource(private val waitingTime: Long) : IdlingResource {
    private val startTime = System.currentTimeMillis()
    private lateinit var resourceCallback: IdlingResource.ResourceCallback

    override fun getName(): String {
        return this.javaClass.name
    }

    override fun isIdleNow(): Boolean {
        val elapsed = System.currentTimeMillis() - startTime;
        val isIdle = (elapsed >= waitingTime)
        if (isIdle) {
            resourceCallback.onTransitionToIdle()
        }
        return isIdle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        resourceCallback = callback!!
    }
}