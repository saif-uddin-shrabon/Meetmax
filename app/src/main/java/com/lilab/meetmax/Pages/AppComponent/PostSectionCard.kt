package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.IconDark
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun PostSectionCard(){

   val shape = CircleShape
    var text by remember { mutableStateOf("") }

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {

            Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)

                )

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(LightColorScheme.background, RoundedCornerShape(10.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            ) {
                BasicTextField(
                    value = text,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (text.isEmpty()) {
                            Text(
                                text = "What's happening?",
                                color = Color.Gray,
                                modifier = Modifier.align(Alignment.CenterStart)

                            )
                        }
                        innerTextField()
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
            ) {


            //Video Icon
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.video_camera),
                        contentDescription = "Image Icon",
                        tint = LightColorScheme.tertiary
                    )

                }

                Text(
                    text = "Live",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 14.sp,
                    color = LightColorScheme.tertiary

                )
            }

            //Photo Section
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.picture),
                        contentDescription = "Image Icon",
                        tint = LightColorScheme.tertiary
                    )

                }

                Text(
                    text = "Photo",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 14.sp,
                    color = LightColorScheme.tertiary

                )
            }

            //Feelings Section
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(45.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.smile),
                        contentDescription = "Image Icon",
                        tint = LightColorScheme.tertiary
                    )

                }

                Text(
                    text = "Feeling",
                    fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                    fontSize = 14.sp,
                    color = LightColorScheme.tertiary

                )
            }

            // Button

            Button(
                modifier = Modifier
                    .width(70.dp)
                    .height(35.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightColorScheme.primary,
                    contentColor = Color.White
                ),

                onClick = { },
            ) {

                    Text(text = "Post",fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                        fontSize = 16.sp,
                    )

            }




        }

    }

}

@Preview(showBackground = true,  widthDp = 360, heightDp = 640)
@Composable
fun PostSectionCardPreview() {
    PostSectionCard()
}
