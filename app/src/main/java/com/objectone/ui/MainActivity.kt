package com.objectone.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.objectone.R
import com.objectone.toothpick.Scopes
import com.objectone.toothpick.activity.ActivityModule
import com.objectone.ui.auth.AuthFlowFragment
import toothpick.Toothpick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityScope = Toothpick.openScopes(Scopes.APP, Scopes.MAIN)
        activityScope.installModules(ActivityModule())
        Toothpick.inject(this, activityScope)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, AuthFlowFragment.newInstance())
                .commitNow()
    }

    // FIXME: not working
    fun showKeyboard(v: View) {
        if (v.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}
