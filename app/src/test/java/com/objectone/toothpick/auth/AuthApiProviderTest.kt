package com.objectone.toothpick.auth

import android.app.Instrumentation
import com.objectone.App
import com.objectone.data.auth.net.AuthApi
import com.objectone.toothpick.Scopes
import com.objectone.toothpick.app.ApplicationModule
import com.objectone.toothpick.network.NetworkModule
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import toothpick.Toothpick

@RunWith(AndroidJUnit4::class)
class AuthApiProviderTest {
    lateinit var api: AuthApi

    @Before
    fun setUp() {
        // TODO: get real api from Toothpick.
        ApplicationProvider.getApplicationContext()
        val appScope = Toothpick.openScope(Scopes.APP)
        appScope.installModules(
                ApplicationModule(Instrumentation.newApplication(App::class.java)),
                AuthModule(),
                NetworkModule())
    }

    @Test
    fun checkAuthIntegration() {

    }
}