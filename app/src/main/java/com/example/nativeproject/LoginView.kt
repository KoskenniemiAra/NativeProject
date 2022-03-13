package com.example.nativeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginView( LoginVM : LoginViewModel) {

    var user by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xfffacca2))
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Please login to continue",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = user,
            onValueChange = {user = it},
            label = { Text(text = "Username") },
            modifier = Modifier
                .padding(10.dp)
        )
        OutlinedTextField(
            value = pw,
            onValueChange = {pw = it},
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(10.dp)
        )
        OutlinedButton(
            onClick = { LoginVM.login( user, pw) },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Login")
        }

    }
}