package com.objectone.toothpick.auth

import androidx.test.core.app.ApplicationProvider
import com.objectone.App
import com.objectone.data.auth.net.AuthApi
import com.objectone.toothpick.Scopes
import com.objectone.toothpick.app.ApplicationModule
import com.objectone.toothpick.network.NetworkModule
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import toothpick.Toothpick

class AuthApiProviderTest {

    private var authApi: AuthApi

    init {
        // FIXME: this injection should be handled in normal way
        val applicationContext = ApplicationProvider.getApplicationContext<App>()
        val appScope = Toothpick.openScope(Scopes.APP)
        appScope.installModules(
                ApplicationModule(applicationContext),
                AuthModule(),
                NetworkModule())
        authApi = appScope.getInstance(AuthApi::class.java)
    }

    @Test
    fun mainTestCase() {
        val testUser = authApi.getAuthData("79858887798").blockingGet()
        assertNotNull(testUser)
        assertTrue(testUser.user.equals("Zemlyakov Stanislav"))

    }
}