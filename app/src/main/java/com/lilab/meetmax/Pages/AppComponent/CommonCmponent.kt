package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme



// Header Section
@Composable
fun Header(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
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
                defaultElevation = 5.dp,
            ),

            //redious
            shape = RoundedCornerShape(2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .width(126.dp)
                .height(32.dp),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "English (UK)",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Normal)),
                    fontSize = 10.sp,
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


// Static Section are used for Login and Signup
@Composable
fun StaticSection(title: String, subtitle: String, newlineTex : String){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
                fontSize = 24.sp,
                lineHeight = 37.sp,
                color = LightColorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(8.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Text(
                    text = subtitle,
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    lineHeight = 29.sp,
                    color = LightColorScheme.tertiary

                )
                // check condition text are not empty & visible
                if (newlineTex.isNotEmpty()) {
                    Text(
                        text = newlineTex,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                        fontSize = 16.sp,
                        lineHeight = 29.sp,
                        color = LightColorScheme.tertiary,

                    )
                }

            }

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp,
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp),

                shape = RoundedCornerShape(3.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightColorScheme.background
                ),


                ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Icon"
                    )
                    Spacer(modifier = Modifier.padding(let { 4.dp }))
                    Text(
                        text = "Log in with Google",
                        fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                        fontSize = 12.sp,
                        color = LightColorScheme.tertiary
                    )


                }
            }

            Spacer(modifier = Modifier.padding(8.dp))
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 1.dp,
                ),
                shape = RoundedCornerShape(3.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(38.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightColorScheme.background // Set the card background color here
                ),

                ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
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
                        fontSize = 12.sp,
                        color = LightColorScheme.tertiary
                    )


                }
            }



        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
            BasicText(
                text = "OR",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
                    color = colorResource(id = R.color.textColor),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
        }


    }

}


// Top profile , search and message section
@Composable
fun ToolbarSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(8.dp))


            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
            )
        Spacer(modifier = Modifier.width(5.dp))

        Row(
            modifier = Modifier
                .height(45.dp)
                .weight(1f)
                .background(Color.White)
                .border(1.dp, colorResource(id = R.color.borderColor), RoundedCornerShape(10.dp)),

            verticalAlignment = Alignment.CenterVertically,

            ) {

            Row(
                modifier = Modifier.padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Send",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )

            }
            Spacer(modifier = Modifier.width(8.dp) )
            BasicTextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier.weight(1f),

                decorationBox = { innerTextField ->
                    Text(
                        text = "Write a comment...",
                        color = Color.Gray,


                        )

                    innerTextField()
                },


                )




        }

        Spacer(modifier = Modifier.width(5.dp) )
            Image(
                painter = painterResource(id = R.drawable.message),
                contentDescription = "Angle Down Icon",
                Modifier
                    .size(30.dp)


            )

        Spacer(modifier = Modifier.width(5.dp))

    }
}


// Custom Button
@Composable
fun ActionButton(icon: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(16.dp),
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}


// Basic Text field
@Composable
fun BasicTextFiledWithHint(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    isEnabled: (Boolean) -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {

        if (value.isEmpty()) {
            Text(text = hint, color = Color.LightGray)
            isEnabled(false)
        }

        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle.Default.copy(Color.Black)
        )

    }
}


@Composable
fun NoPostFound() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.nopostfound),
            contentDescription = "No Post Found",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))


        Column(
            modifier = Modifier
                        .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text =   "No Post Found!",
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
                lineHeight = 29.sp,
                color = LightColorScheme.tertiary

            )
                Text(
                    text = " Please post something to see here.",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 16.sp,
                    lineHeight = 29.sp,
                    color = LightColorScheme.tertiary,

                    )


        }


    }
}

//Dialog box
@Composable
fun WarningDialog(
    title: String,
    message: String,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 18.sp,
                color = Color.Red
            )
        },
        text = {
            Text(
                text = message,
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
                color = Color.Gray
            )
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm() }
            ) {
                Text(
                    text = "Ok",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    color = Color.Red
                )
            }
        }
    )
}



//Devider
@Composable
fun CustomDevider(){
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.LightGray, thickness = 1.dp)
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun HeaderLayout() {
   // StaticSection(title = "Sign in", subtitle ="Welcome Back! You've been missed!", newlineTex = "password to continue" )

//    CustomButton(text = "Login", onClick = {}, modifier = Modifier.padding(16.dp).height(20.dp).width(10.dp))

   // StaticSection(title = "Login", subtitle ="Hello", newlineTex ="welcome")

  //  Header()
    //NoPostFound()

    ToolbarSection()

   // WarningDialog(title = "Warning", message = "Are you sure you want to delete this post?",  onConfirm = {})
}