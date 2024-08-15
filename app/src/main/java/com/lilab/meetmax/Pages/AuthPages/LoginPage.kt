package com.lilab.meetmax.Pages.AuthPages


import androidx.compose.foundation.Image

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.R
import com.lilab.meetmax.ViewModel.AuthViewModel
import com.lilab.meetmax.ui.theme.LightColorScheme


@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {



    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

    ) {


        Header()
        StaticSection()
        MiddleSection() // functional section



    }
}




@Composable
fun Header(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 34.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {



        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Icon",
                modifier = Modifier
                    .height(21.dp)
                    .width(21.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Text(
                text = "MeetMax",
                fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
                fontSize = 16.sp,
                color = LightColorScheme.tertiary
            )

        }


        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp,
            ),

            //redious
            shape = RoundedCornerShape(2.dp),
            colors = CardDefaults.cardColors(
                containerColor = LightColorScheme.background 
            ),
            modifier = Modifier
                .width(126.dp)
                .height(32.dp),




        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "English (UK)",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Normal)),
                    fontSize = 13.sp,
                    color = LightColorScheme.tertiary
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.angle_down),
                    contentDescription = "Angle Down Icon"
                )
            }
        }
    }

}

@Composable
fun StaticSection(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Sign In",
                fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
                fontSize = 24.sp,
                lineHeight = 37.sp,
                color = LightColorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Welcome Back! You've been missed!",
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 19.sp,
                lineHeight = 29.sp,
                color = LightColorScheme.tertiary

            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp,
                ),
                shape = RoundedCornerShape(3.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightColorScheme.background
                ),


            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Angle Down Icon"
                    )
                    Spacer(modifier = Modifier.padding(let { 4.dp }))
                    Text(
                        text = "Log in with Google",
                        fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                        fontSize = 16.sp,
                        color = LightColorScheme.tertiary
                    )


                }
            }

            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp,
                ),
                shape = RoundedCornerShape(3.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightColorScheme.background // Set the card background color here
                ),

            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Angle Down Icon"
                    )
                    Spacer(modifier = Modifier.padding(let { 4.dp }))
                    Text(
                        text = "Log in with Apple",
                        fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                        fontSize = 16.sp,
                        color = LightColorScheme.tertiary
                    )


                }
            }
        }


    }

}


@Composable
fun MiddleSection(){
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val passwordVisible  =  remember {
        mutableStateOf(false)
    }

    var checked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(16.dp),
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
                    painter = painterResource(id = R.drawable.mail__), // Replace with your email icon
                    contentDescription = "Email Icon",
                    tint = Color.Gray
                )
            },

        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier= Modifier.fillMaxWidth(),
            label = {
                Text("Password",fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.tertiary)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password,
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock), // Replace with your password icon
                    contentDescription = "Password Icon",
                    tint = Color.Gray
                )
            },
            trailingIcon = {
                val iconImage = if (passwordVisible.value) {
                    Icons.Filled.Visibility
                } else {
                    Icons.Filled.VisibilityOff
                }
                val description = if (passwordVisible.value) "Hide Password" else "Show Password"

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(
                        imageVector = iconImage,
                        contentDescription = description
                    )
                }
            },
            visualTransformation = if (passwordVisible.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
        )

        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Gray,
                        uncheckedColor = Color.Gray,
                        checkmarkColor = Color.White
                    )
                )

                Text(
                    text = "Remember me",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.tertiary
                )
            }


            TextButton(onClick = {  },) {
                Text(text = "Forget Password?", fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.tertiary)

            }
        }


        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(7.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightColorScheme.primary,
                contentColor = Color.White
            )

        ) {
            Text(text = "Login",fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
                )
        }


        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have an account? ", fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
                color = LightColorScheme.tertiary)
            TextButton(onClick = {  }) {
                Text(text = "Sign up", fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                   color = LightColorScheme.secondary)
            }

        }


    }
}

//@PreviewScreenSizes
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun LoginPagePreview() {
    val mockNavController = rememberNavController()
    val mockAuthViewModel = AuthViewModel()

    LoginPage(navController = mockNavController, authViewModel = mockAuthViewModel)
}
