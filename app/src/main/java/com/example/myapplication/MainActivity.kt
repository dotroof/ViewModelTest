package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonText = "Count"

        val viewModel: MainViewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)

        val button = findViewById<TextView>(R.id.button)
        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)

        button.setOnClickListener {
            viewModel.pushCount.value = viewModel.pushCount.value!! + 1
        }

        if (viewModel.rotationCount == 0) {
            text1.text = viewModel.text
        } else {
            text1.text = viewModel.rotationCount.toString()
        }

        val pushCountObserver = Observer<Int> { pushCount ->
            text2.text = pushCount.toString()
        }

        viewModel.rotationCount++
        viewModel.pushCount.observe(this, pushCountObserver)
    }
}
