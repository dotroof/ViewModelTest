package com.example.myapplication

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val text: String = "Hello World!"
    var rotationCount: Int = 0
}
