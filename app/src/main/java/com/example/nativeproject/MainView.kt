package com.example.nativeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val HomeNav = "home"
const val NewsNav = "news"
const val PhotoNav = "photo"

@Composable
fun MainView(navController: NavHostController) {

    val user = viewModel<LoginViewModel>()

    if(!user.loggedIn.value) {
        LoginView(user)
    }
    else {
        NavHost(navController = navController, startDestination = HomeNav) {
            composable( route = HomeNav) { HomeView(user) }
            composable( route = PhotoNav) { PhotoView() }
            composable( route = NewsNav) { NewsMain() }
        }
    }
}


@Composable
fun ContentView() {

    val login = viewModel<LoginViewModel>()

    val navController = rememberNavController()

    Scaffold(
        topBar = { TopBar(login) },
        content = { MainView(navController) },
        bottomBar = { if(login.loggedIn.value)
                        {BottomBar(navController)}
                    else {
                        BottomBarNoNav()}
                    }
    )
}


