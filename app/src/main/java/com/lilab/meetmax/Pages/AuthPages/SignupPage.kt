package com.lilab.meetmax.Pages.AuthPages

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AppComponent.Header
import com.lilab.meetmax.Pages.AppComponent.StaticSection
import com.lilab.meetmax.Pages.AppComponent.WarningDialog
import com.lilab.meetmax.Pages.Navigation.Destination
import com.lilab.meetmax.R
import com.lilab.meetmax.ViewModel.AuthViewModel
import com.lilab.meetmax.services.domain.AuthEvents
import com.lilab.meetmax.services.model.CreatUserData
import com.lilab.meetmax.services.utils.NetworkResult
import com.lilab.meetmax.ui.theme.LightColorScheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SignupPage(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    signupViewModel: AuthViewModel
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


            // Header & Static Section from AppComponent
            Header()
            StaticSection(title = "Getting Started", subtitle = "Create an account to continue and", newlineTex = "connect with the people.")
            SignpuFuntionalSection(navController = navController, signupViewModel) // functional section



        }
    }
}

@Composable
fun SignpuFuntionalSection(
    navController: NavController,
    signupViewModel: AuthViewModel
) {


    var email by remember {
        mutableStateOf("")
    }
    
    var name by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val passwordVisible  =  remember {
        mutableStateOf(false)
    }

    var selectedDate by remember {
        mutableStateOf("")
    }

    var selectedGender by remember {
        mutableStateOf("Male")
    }

    val context = LocalContext.current

    val signinResult by signupViewModel.registerResult.observeAsState(null)
    var isLoading by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    // for data collection or listening to the state
    LaunchedEffect(signinResult) {
        when (signinResult) {
            is NetworkResult.Error -> {
             //  Toast.makeText(context, signinResult!!.message, Toast.LENGTH_SHORT).show()
                dialogMessage = signinResult!!.message.toString() ?: "An error occurred"
                showDialog = true
                isLoading = false

                // Clear warning dialog
                signupViewModel.resetLiveData()
            }

            is NetworkResult.Loading -> {
                isLoading = true

            }

            is NetworkResult.Success -> {

                if (signinResult!!.data != null){

                    Toast.makeText(context, "Sign in Successful", Toast.LENGTH_SHORT).show()
                    navController.navigate(Destination.Login) {
                        popUpTo(Destination.Signup) {
                            inclusive = true
                        }
                    }
                }

                isLoading = false


            }

            null -> {}
        }

    }
    // Dialog for error message
    if(showDialog){
        WarningDialog(
            title = "Warning",
            message = dialogMessage,
            onConfirm = { showDialog = false }
        )
    }

    Column(
        modifier = Modifier.padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // TextField for Email
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            label = {
                Text(
                    text = "Your Email",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.tertiary
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail__), // Replace with your email icon
                    contentDescription = "Email Icon",
                    tint = Color.Gray
                )
            },

            )
        Spacer(modifier = Modifier.height(16.dp))

        // TextField for Name
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            singleLine = true,
            label = {
                Text(
                    text = "Your Name",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.tertiary
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.smile), // Replace with your email icon
                    contentDescription = "smile Icon",
                    tint = Color.Gray
                )
            },

            )
        Spacer(modifier = Modifier.height(16.dp))

        // TextField for Password
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(
                    "Password", fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password,
            onValueChange = {
                password = it
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = "Password Icon",
                    tint = Color.Gray
                )
            },
            // Password Visibility Icon & Functionality
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

        Spacer(modifier = Modifier.height(16.dp))

        // DatePicker component function placed below
        DatePicker(selectedDate){ data ->
            selectedDate = data
        }

        Spacer(modifier = Modifier.height(8.dp))

        // GenderSelectionRow component function placed below
        GenderSelectionRow(selectedGender){ gender ->
            selectedGender = gender
        }


        Spacer(modifier = Modifier.height(16.dp))



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


                    val createUserDate = CreatUserData(
                        email = email,
                        fullName = name,
                        password = password,
                        DOB = selectedDate.toString().trim(),
                        gender = selectedGender.toString().trim()
                    )

                    signupViewModel.UserEventState(
                        AuthEvents.OnRegister(
                            createUserDate
                        )
                    )

                    isLoading = true
                },
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 5.dp),
                    text = "Sign Up",
                    fontSize = 16.sp
                )
            }

        }

        if (isLoading) {
            Spacer(modifier = Modifier.height(5.dp))
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account? ",
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
                color = LightColorScheme.tertiary
            )
            TextButton(onClick = {
                navController.navigate(Destination.Login) {
                    popUpTo(Destination.Signup) {
                        inclusive = true
                    }
                }
            }
            ) {
                Text(
                    text = "Sign In",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    color = LightColorScheme.secondary
                )
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker(
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    // Update the selectedDate when the user picks a date from the date picker
    LaunchedEffect(datePickerState.selectedDateMillis) {
        datePickerState.selectedDateMillis?.let {
            onDateSelected (convertMillisToDate(it))
            showDatePicker = false
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { it ->
              onDateSelected(it)

            },
            leadingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            label = { Text("DOB") },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}


@Composable
fun GenderSelectionRow(
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .background(Color.White)
            .height(55.dp),
        shape = RoundedCornerShape(2.dp),
        border = BorderStroke(1.dp, Color.Gray ),
        colors = CardDefaults.cardColors(
            containerColor = LightColorScheme.background
        ),

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id
                = R.drawable.male),
                contentDescription = "Male",
                modifier = Modifier.size(24.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedGender == "Male",
                    onClick = {
                        onGenderSelected("Male")
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                        unselectedColor = Color.Gray
                    )
                )
                Text(text = "Male")
            }

            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedGender == "Female",
                    onClick = {
                             onGenderSelected("Female")
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Blue,
                        unselectedColor = Color.Gray
                    )
                )
                Text(text = "Female")
            }

        }
    }

}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun SignupLayout() {
    val mockNavController = rememberNavController()
    val signupViewModel = viewModel<AuthViewModel>()



    SignupPage(navController = mockNavController, signupViewModel = signupViewModel)
}
