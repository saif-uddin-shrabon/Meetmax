package com.lilab.meetmax.Pages.MainPages

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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilab.meetmax.Pages.AppComponent.ActionButton
import com.lilab.meetmax.Pages.AppComponent.CustomButton
import com.lilab.meetmax.Pages.AppComponent.ToolbarSection
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun CreatPost() {

    Surface(

        modifier = Modifier.fillMaxSize()
    ) {
       Column(
              modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
              horizontalAlignment = Alignment.CenterHorizontally
       ) {
           ToolbarSection()

           CreatePostScreen()
       }
    }
}

@Composable
fun CreatePostScreen(){
     Column(
            modifier =  Modifier.padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
     ) {
            Spacer(modifier = Modifier.height(8.dp))
            HeadingSectionoOfCreatPost()
            Spacer(modifier = Modifier.height(8.dp))
            PostContent()
            Spacer(modifier = Modifier.height(8.dp))
            ActionPerformer()
           Spacer(modifier = Modifier.height(18.dp) )
           CustomButton(
                text = "Post",
                onClick = {},
           )

     }

}

@Composable
fun HeadingSectionoOfCreatPost(){

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Icon(
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = "Arrow Back",
            modifier = Modifier
                .size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Creat a Post",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Visible for",
            fontSize = 12.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .height(32.dp)
                .width(80.dp)
                .background(LightColorScheme.background, RoundedCornerShape(8.dp)),

            ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Friends",
                    fontSize = 12.sp,
                    color = LightColorScheme.secondary,
                    modifier = Modifier.padding(8.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.angle_down),
                    contentDescription = "Arrow Down",
                    modifier = Modifier
                        .size(16.dp)
                )

            }
        }
        Spacer(modifier = Modifier.width(8.dp))


    }
}


@Composable
fun PostContent(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .padding(8.dp),
            singleLine = false,
            decorationBox = { innerTextField ->
                if (true) { // Replace 'true' with condition to check if value is empty
                    Text(
                        text = "What's happening?",
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        )

    }
}


@Composable
fun ActionPerformer(){

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()

    ) {
        ActionButton(icon = R.drawable.video_camera, text = "Video")
        ActionButton(icon = R.drawable.picture, text = "Picture")
        ActionButton(icon = R.drawable.smile, text = "Smile")
    }

}




@Preview(showBackground = true, heightDp = 650, widthDp = 360)
@Composable
fun CreatPostPreview() {
    CreatPost()
}