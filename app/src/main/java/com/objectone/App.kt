package com.objectone

import android.app.Application
import com.objectone.toothpick.app.ApplicationModule
import com.objectone.toothpick.network.NetworkModule
import com.objectone.toothpick.Scopes
import toothpick.Toothpick
import toothpick.configuration.Configuration.forDevelopment
import toothpick.configuration.Configuration.forProduction
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val configuration = if (BuildConfig.DEBUG) forDevelopment() else forProduction()
        Toothpick.setConfiguration(configuration.disableReflection())

        MemberInjectorRegistryLocator.setRootRegistry(com.objectone.MemberInjectorRegistry())
        FactoryRegistryLocator.setRootRegistry(com.objectone.FactoryRegistry())

        val appScope = Toothpick.openScope(Scopes.APP)
        appScope.installModules(
                ApplicationModule(this),
                NetworkModule("localhost:8080"))
    }
}