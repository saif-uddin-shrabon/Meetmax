package com.lilab.meetmax.Pages.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AuthPages.ForgetPasswordPage
import com.lilab.meetmax.Pages.AuthPages.LoginPage
import com.lilab.meetmax.Pages.AuthPages.SignupPage
import com.lilab.meetmax.Pages.MainPages.HomePage
import com.lilab.meetmax.ViewModel.AuthViewModel



@Composable
fun MyAppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SubGraph.Auth) {

        navigation<SubGraph.Auth>(startDestination = Destination.Login){
            composable<Destination.Login> {
                 LoginPage(navController = navController)

                }


            composable<Destination.Signup> {
                SignupPage (navController = navController)

                }
            }

            composable<Destination.ForgetPassword> {
                ForgetPasswordPage (navController = navController)

             }


        navigation<SubGraph.App>(startDestination = Destination.MainScreen){
            composable<Destination.MainScreen> {  }
        }

    }


    }







