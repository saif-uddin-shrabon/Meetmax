package com.lilab.meetmax.Pages.AuthPages

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lilab.meetmax.Pages.AppComponent.Header
import com.lilab.meetmax.Pages.AppComponent.StaticSection
import com.lilab.meetmax.Pages.AppComponent.WarningDialog
import com.lilab.meetmax.Pages.Navigation.Destination
import com.lilab.meetmax.R
import com.lilab.meetmax.ViewModel.AuthViewModel
import com.lilab.meetmax.services.domain.AuthEvents
import com.lilab.meetmax.services.utils.NetworkResult
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun ForgetPasswordPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    forgetPasswordViewModel: AuthViewModel

) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White),

            ) {


            // Header & StaticSection from AppComponent
            Header()
            StaticSection(title = stringResource(id = R.string.forget_password), subtitle = stringResource(
                id = R.string.forget_password_desc
            ), newlineTex = "")

            ForgetPassFuntionality(navController = navController,forgetPasswordViewModel = forgetPasswordViewModel)

        }
    }
}

@Composable
fun ForgetPassFuntionality(navController: NavController,forgetPasswordViewModel: AuthViewModel){
    var email by remember {
        mutableStateOf("")
    }


    val forgetResult by forgetPasswordViewModel.forgetPasswordResult.observeAsState(null)
    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current

    // for data collection or listening from livedata
    LaunchedEffect(forgetResult) {
        when (forgetResult) {
            is NetworkResult.Loading -> {
                isLoading = true
            }
            is NetworkResult.Error -> {
                isLoading = false
                Toast.makeText(context, forgetResult!!.message, Toast.LENGTH_SHORT).show()

            }
            is NetworkResult.Success -> {
                isLoading = false
                val message = forgetResult!!.data!!.responseMessage ?: "Password reset link sent to your email"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                navController.navigate(Destination.Login) {
                    popUpTo(Destination.ForgetPassword) {
                        inclusive = true
                    }
                }
            }
            null -> {}
        }
    }

    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            modifier= Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Your Email",fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
                color = LightColorScheme.tertiary) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail__),
                    contentDescription = "Email Icon",
                    tint = Color.Gray
                )
            },

            )

        Spacer(modifier = Modifier.height(16.dp))

        // Sign In button with loading state
        var showDialog by remember { mutableStateOf(false) }
        var dialogMessage by remember { mutableStateOf("") }

        AnimatedVisibility(!isLoading) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(53.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightColorScheme.primary,
                    contentColor = Color.White
                ),
                onClick = {

                    if (email.isEmpty()) {
                        //Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
                        dialogMessage = "Please enter your email"
                        showDialog = true


                        return@Button
                    }else{
                        forgetPasswordViewModel.forgetPassword(email.trim())
                    }

                    isLoading = true
                },
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 5.dp),
                    text = "Send",
                    fontSize = 16.sp
                )
            }

        }

        // Loading indicator
        if (isLoading) {
            Spacer(modifier = Modifier.height(5.dp))
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
            )
        }

        // Dialog for warning
        if(showDialog){
            WarningDialog(
                title = "Warning",
                message = dialogMessage,
                onConfirm = { showDialog = false }
            )
        }



        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "App Icon",
                modifier = Modifier
                    .height(21.dp)
                    .width(21.dp)
                    .align(Alignment.CenterVertically)
            )
            TextButton(onClick = {
                navController.navigate(Destination.Login){
                    popUpTo(Destination.ForgetPassword){
                        inclusive = true
                    }
                }
            }) {
                Text(text = "Back to Sign In", fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.secondary)
            }

        }


    }
}

//@Preview(showBackground = true, widthDp = 360, heightDp = 640)
//@Composable
//fun ForgetPassLayout() {
//    val mockNavController = rememberNavController()
//    val mockAuthViewModel = AuthViewModel()
//
//    ForgetPasswordPage(
//        onForgetPassword = {}
//    )
//}