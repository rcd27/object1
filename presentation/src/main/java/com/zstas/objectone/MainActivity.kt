package com.zstas.objectone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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