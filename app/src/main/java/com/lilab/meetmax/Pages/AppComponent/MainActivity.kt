package com.lilab.meetmax.Pages.AppComponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lilab.meetmax.Pages.Navigation.MyAppNavigation
import com.lilab.meetmax.ViewModel.AuthVieModel.AuthViewModel
import com.lilab.meetmax.ui.theme.MeetmaxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val authViewModel: AuthViewModel  by viewModels()
        setContent {
           MeetmaxTheme {
               Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                   MyAppNavigation(modifier = Modifier.padding(innerPadding), authViewModel = authViewModel)

               }
           }




        }
    }
}




