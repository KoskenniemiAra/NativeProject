package com.example.nativeproject

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var user = mutableStateOf("")
    var loggedIn = mutableStateOf(false)

    fun login(username: String, pw: String) {
        user.value = username
        loggedIn.value = true
    }

    fun logout() {
        user.value = ""
        loggedIn.value = false
    }
}