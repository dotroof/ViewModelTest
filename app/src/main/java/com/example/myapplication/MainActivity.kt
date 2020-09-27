package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)

        val text1 = findViewById<TextView>(R.id.text1)
        if (viewModel.rotationCount == 0) {
            text1.text = viewModel.text
        } else {
            text1.text = viewModel.rotationCount.toString()
        }

        viewModel.rotationCount++
    }
}
