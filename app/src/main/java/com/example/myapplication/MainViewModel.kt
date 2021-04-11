package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val text: String = "Hello World!"
    var rotationCount: Int = 0

    val pushCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        pushCount.value = 0
    }
}
