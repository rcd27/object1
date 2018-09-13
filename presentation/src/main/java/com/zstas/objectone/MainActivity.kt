package com.zstas.objectone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// TODO: check the `lintFix` new Gradle task. This apply safe fixes to the code.
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bar {
            println("WAZZZZAAAAAP")
        }
    }

    private fun bar(a: () -> Unit) {
        a.invoke()
    }
}