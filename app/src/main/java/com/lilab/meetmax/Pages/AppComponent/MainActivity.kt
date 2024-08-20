package com.lilab.meetmax.Pages.AppComponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.Navigation.Destination
import com.lilab.meetmax.Pages.Navigation.MainNavigation
import com.lilab.meetmax.ViewModel.AuthViewModel
import com.lilab.meetmax.ViewModel.PostViewModel
import com.lilab.meetmax.services.utils.SharedPref.getUserId
import com.lilab.meetmax.ui.theme.MeetmaxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authViewModel: AuthViewModel by viewModels()
        val postViewModel: PostViewModel by viewModels()
        setContent {
           MeetmaxTheme {
               Surface {
                   val navController = rememberNavController()
                   if (getUserId(this) != "") {
                       MainNavigation(authViewModel = authViewModel, postViewModel = postViewModel, navController = navController, startDestination = Destination.MainScreen )
                   } else {
                       MainNavigation(
                           authViewModel = authViewModel,
                           postViewModel = postViewModel,
                           navController = navController,
                           startDestination = Destination.Login
                       )
                   }
               }
           }




        }
    }
}




