package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilab.meetmax.Pages.MainPages.SearchBar
import com.lilab.meetmax.R
import com.lilab.meetmax.services.domain.AuthEvents
import com.lilab.meetmax.ui.theme.IconDark
import com.lilab.meetmax.ui.theme.LightColorScheme

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



// Custom Button 1
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        shape = RoundedCornerShape(7.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LightColorScheme.primary,
            contentColor = Color.White
        ),

                onClick = onClick
    ) {


            Text(text = text,fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                fontSize = 16.sp,
            )

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

        Spacer(modifier = Modifier.width(5.dp))

        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

        }
        SearchBar()

        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.message),
                contentDescription = "Angle Down Icon",
                Modifier
                    .size(24.dp)

            )

        }

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






@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun HeaderLayout() {
   // StaticSection(title = "Sign in", subtitle ="Welcome Back! You've been missed!", newlineTex = "password to continue" )

//    CustomButton(text = "Login", onClick = {}, modifier = Modifier.padding(16.dp).height(20.dp).width(10.dp))

    StaticSection(title = "Login", subtitle ="Hello", newlineTex ="welcome")

   // Header()
}