package com.example.nativeproject

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PhotoViewModel: ViewModel() {
    var OpenPhoto = mutableStateOf<Int>(R.drawable.forest)
}