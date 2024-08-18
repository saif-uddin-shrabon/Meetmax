package com.lilab.meetmax.Pages.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AuthPages.ForgetPasswordPage
import com.lilab.meetmax.Pages.AuthPages.LoginPage
import com.lilab.meetmax.Pages.AuthPages.SignupPage
import com.lilab.meetmax.Pages.MainPages.CreatPost
import com.lilab.meetmax.Pages.MainPages.HomePage
import com.lilab.meetmax.Pages.MainPages.MainScreen
import com.lilab.meetmax.ViewModel.AuthViewModel


@Composable
fun MainNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel, navController: NavHostController, startDestination: Destination) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,

        startDestination = startDestination
    ) {



        composable<Destination.Login>{
            LoginPage(
                navController = navController,
                signinViewModel = authViewModel
            )
        }

        composable<Destination.Signup>{
            SignupPage(
                navController = navController,
                signupViewModel = authViewModel
            )
        }

        composable<Destination.ForgetPassword>{
            ForgetPasswordPage(
                navController = navController
            )
        }

        composable<Destination.MainScreen>{
            MainScreen(
                navHostController = navController
            )
        }

        composable<Destination.CreatPost>{
            CreatPost(navController)
        }

        composable<Destination.HomePage>{
            HomePage(navHostController = navController)
        }


        composable<Destination.HomePage> {

        }


        /*
        navigation<SubGraph.Auth>(startDestination = Destination.Login){
            composable<Destination.Login> {
                 LoginPage(navController = navController, signinViewModel = authViewModel)

                }


            composable<Destination.Signup> {
                SignupPage (navController = navController, signupViewModel = authViewModel)

                }
            }

            composable<Destination.ForgetPassword> {
                ForgetPasswordPage (navController = navController)

             }


        navigation<SubGraph.App>( startDestination = Destination.MainScreen){
            composable<Destination.MainScreen> {
                MainScreen()
            }

            */

        }



    }










