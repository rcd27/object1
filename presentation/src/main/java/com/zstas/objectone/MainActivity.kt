package com.zstas.objectone

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bar  {
            println("WAZZZZAAAAAP")
        }
    }

    fun bar(a: () -> Unit) {
        a.invoke()
    }
}