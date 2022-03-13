package com.example.nativeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeView(loginVM : LoginViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xfffacca2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_baseline_hourglass_bottom_24),
            contentDescription = "mainIcon",
            modifier = Modifier.size(200.dp) .border(3.dp, Color.Black))
        Text(text = "Welcome ${loginVM.user.value}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp, bottom = 200.dp)
        )
    }

}