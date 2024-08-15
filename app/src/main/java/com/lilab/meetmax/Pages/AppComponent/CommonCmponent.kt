package com.lilab.meetmax.Pages.AppComponent

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.lilab.meetmax.R
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
                    fontSize = 19.sp,
                    lineHeight = 29.sp,
                    color = LightColorScheme.tertiary

                )
                // check condition text are not empty & visible
                if (newlineTex.isNotEmpty()) {
                    Text(
                        text = newlineTex,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                        fontSize = 19.sp,
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
                    .width(182.dp)
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "google Icon"
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
                modifier = Modifier
                    .width(182.dp)
                    .height(38.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightColorScheme.background // Set the card background color here
                ),

                ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
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


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun HeaderLayout() {
    StaticSection(title = "Sign in", subtitle ="Welcome Back! You've been missed!", newlineTex = "password to continue" )
}