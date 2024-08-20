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
import com.lilab.meetmax.ViewModel.PostViewModel


@Composable
fun MainNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel,postViewModel: PostViewModel, navController: NavHostController, startDestination: Destination) {

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
                navController = navController,
                forgetPasswordViewModel = authViewModel
            )
        }

        composable<Destination.MainScreen>{
            MainScreen(
                navHostController = navController,
                postViewModel = postViewModel

            )
        }

        composable<Destination.CreatPost>{
            CreatPost(
                navController,
                postViewModel
            )
        }

        composable<Destination.HomePage>{
            HomePage(
                navHostController = navController,postViewModel = postViewModel

            )

        }


        composable<Destination.HomePage> {

        }




        }



    }










