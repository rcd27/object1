package com.objectone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.objectone.R
import com.objectone.toothpick.activity.ActivityModule
import com.objectone.toothpick.Scopes
import com.objectone.ui.list.ListFragment
import toothpick.Toothpick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityScope = Toothpick.openScopes(Scopes.APP, Scopes.MAIN)
        activityScope.installModules(ActivityModule())
        Toothpick.inject(this, activityScope)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment.newInstance())
                    .commitNow()
        }
    }
}
