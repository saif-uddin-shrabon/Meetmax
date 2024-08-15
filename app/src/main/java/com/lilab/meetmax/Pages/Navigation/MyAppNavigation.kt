package com.lilab.meetmax.Pages.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AuthPages.ForgetPasswordPage
import com.lilab.meetmax.Pages.AuthPages.LoginPage
import com.lilab.meetmax.Pages.AuthPages.SignupPage
import com.lilab.meetmax.Pages.MainPages.HomePage
import com.lilab.meetmax.ViewModel.AuthViewModel

@Composable
fun MyAppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignupPage(modifier, navController, authViewModel)
        }

        composable("forgetPassword") {
            ForgetPasswordPage(modifier, navController, authViewModel)
        }

        composable("home") {
            HomePage(modifier, navController, authViewModel)
        }
    })

}