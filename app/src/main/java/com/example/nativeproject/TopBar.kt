package com.example.nativeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TopBar( LoginVM : LoginViewModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(color = Color(0xffeb7e1e)),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        if( LoginVM.loggedIn.value) {
            Text(text = "Currently logged in: ${LoginVM.user.value}", modifier = Modifier.padding(start = 12.dp), fontWeight = FontWeight.Bold)
            OutlinedButton(onClick = { LoginVM.logout() },
            modifier = Modifier.padding(end=15.dp)) {
                Text(text = "Logout")
            }
        }
    }
}