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
fun MyAppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.Login) {

        composable<Destination.Login> {
            LoginPage(
                onSignupClick = {
                    navController.navigate(Destination.Signup) {
                        popUpTo(Destination.Login) {
                            inclusive = true
                        }
                    }
                },
                onForgetPassClick = {
                    navController.navigate(Destination.ForgetPassword) {
                        popUpTo(Destination.Login) {
                            inclusive = true
                        }
                    }
                }
            )
        }


            composable<Destination.Signup> {


                SignupPage {
                    navController.navigate(Destination.Login) {
                        popUpTo(Destination.Signup) {
                            inclusive = true
                        }
                    }
                }
            }

            composable<Destination.ForgetPassword> {

                    ForgetPasswordPage {
                        navController.navigate(Destination.Login) {
                            popUpTo(Destination.ForgetPassword) {
                                inclusive = true
                            }
                        }
                    }

            }

            composable<Destination.Home> {

            }
        }
    }







