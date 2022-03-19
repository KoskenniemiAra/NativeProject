package com.example.nativeproject

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {
    var user = mutableStateOf("")
    var loggedIn = mutableStateOf(false)

    fun login(username: String, pw: String) {
        Firebase.auth
            .signInWithEmailAndPassword(username, pw)
            .addOnSuccessListener {
                user.value = username
                loggedIn.value = true
            }
            .addOnFailureListener() {
                Log.d("*************", "error occurred")
                Log.d("XXXXXXXXXXXXXXX", it.message!!)
            }
    }

    fun logout() {
        Firebase.auth.signOut()
        user.value = ""
        loggedIn.value = false
    }
}