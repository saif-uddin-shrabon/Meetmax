package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme
import com.lilab.meetmax.ui.theme.textColor

@Composable
fun StoryComponent(imageUrl : String) {


    val shape = CircleShape
    Box(modifier = Modifier.background(Color.White)){
        Column (

            modifier = Modifier.padding(start = 10.dp ,top =16.dp, end = 10.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .diagonalGradientBorder(
                        colors = listOf(
                            Color(0xFF377DFF),
                            Color(0xFF377DFF),
                            Color(0xFF377DFF),
                        ),
                        shape = shape,
                        isFromRight = true
                    )
            ) {
                Box(
                    modifier = Modifier
                        .size(66.dp)
                        .padding(6.dp)
                        .background(color = Color.LightGray, shape = shape)
                        .clip(shape)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(imageUrl),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize().
                        clip(shape)
                    )
                }
            }


            Text(
                text = "Saif",
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = LightColorScheme.tertiary,
                modifier = Modifier.padding(top = 8.dp)
            )

        }
    }



}

@Preview(showBackground = true )
@Composable
fun StoryImagePreview() {
    StoryComponent("https://picsum.photos/200/300")
}
