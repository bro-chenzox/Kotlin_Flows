package com.palchak.sergey.kotlinflows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Producer
        val flow = flow {
            for (i in 1..10) {
                emit("Hello World!")
                delay(1000)
            }
        }

        // Consumer
        GlobalScope.launch {
            flow.collect {
                println(it)
            }
        }
    }

}