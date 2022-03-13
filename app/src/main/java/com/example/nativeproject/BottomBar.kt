package com.example.nativeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun BottomBar(navController: NavHostController) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(color = Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_home_24),
            contentDescription = "home",
            modifier = Modifier
                .size(50.dp)
                .clickable { navController.navigate(HomeNav) }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_photo_library_24),
            contentDescription = "photo",
            modifier = Modifier
                .size(50.dp)
                .clickable { navController.navigate(PhotoNav) }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
            contentDescription = "news",
            modifier = Modifier
                .size(50.dp)
                .clickable { navController.navigate(NewsNav) }
        )
    }
}

@Composable
fun BottomBarNoNav() {

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(color = Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_home_24),
            contentDescription = "home",
            modifier = Modifier
                .size(50.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
            contentDescription = "home",
            modifier = Modifier
                .size(50.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
            contentDescription = "news",
            modifier = Modifier
                .size(50.dp)
        )
    }
}