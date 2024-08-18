package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun PostItem() {
         Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.White
         ) {
             Column(
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(8.dp)
             ) {

                 UserDetails()
                 PostContetnt()
                 ReactionsSection()
                 ActionPerpormer()
                 Comments()



             }
             
         }
}

@Composable
fun UserDetails(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

    ){


        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text ="Saif Uddin",
                fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
                fontSize = 16.sp,
                color = LightColorScheme.tertiary
            )

            Text(
                text = "15h." + " Public",
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Normal)),
                fontSize = 12.sp,
                color = Color(0xFF4E5D7899),
            )

        }

        Spacer(modifier = Modifier.weight(1f))


        Icon(painter = painterResource(id = R.drawable.threedot),
            contentDescription = "More Option")


    }
}

@Composable
private fun PostContetnt() {

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "If you think adventure is dangerous, try routine, it’s lethal Paulo Coelho! Good morning all friends.",
        fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Normal)),
        fontSize = 14.sp,
        color = LightColorScheme.tertiary
    )

    Spacer(modifier = Modifier.height(8.dp))

    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "profile",

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .size(200.dp, 200.dp)
            .clip(RoundedCornerShape(8.dp))
        )
}

@Composable
private fun ReactionsSection() {
    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment =  Alignment.CenterVertically,
        ){

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Reaction 1",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Reaction 2",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Reaction 3",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
            )

    }

        //CircleBox
        Box(modifier = Modifier
            .size(20.dp)
            .background(Color.Gray, CircleShape),
            contentAlignment = Alignment.Center,

        ){
            Text(
                text = "+8",
                fontSize = 12.sp,
                color = Color.White
            )
        }


        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "3 Comments  5 Shares",
            fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Normal)),
            fontSize = 12.sp,
            color = LightColorScheme.tertiary
        )

    }
}

@Composable
fun ActionPerpormer(){
    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.LightGray, thickness = 1.dp)
    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ActionButton(icon = R.drawable.heart_2, text = "Like")
        ActionButton(icon = R.drawable.comment, text = "Comments")
        ActionButton(icon = R.drawable.share, text = "Share")
    }

    Spacer(modifier = Modifier.height(8.dp))
    Divider(color = Color.LightGray, thickness = 1.dp)
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun Comments(){

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){

        Image(
            painter = painterResource(id = R.drawable.profile), // Replace with your profile image resource
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
        )


        Box(
            modifier = Modifier
                .height(45.dp)
                .wrapContentWidth()
                .background(LightColorScheme.background, RoundedCornerShape(10.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.CenterVertically),
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicTextField(
                    value = "",
                    onValueChange = {},
                    singleLine = true,

                    decorationBox = { innerTextField ->
                        Text(
                            text = "Write a comment...",
                            color = Color.Gray,


                        )

                        innerTextField()
                    },


                    )

                Spacer(modifier =  Modifier.width(8.dp) )

                Icon(
                    painter = painterResource(id = R.drawable.gif),
                    contentDescription = "Send",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )

                Spacer(modifier =  Modifier.width(8.dp) )
                Icon(
                    painter = painterResource(id = R.drawable.picture),
                    contentDescription = "Send",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )
                Spacer(modifier =  Modifier.width(8.dp) )
                Icon(
                    painter = painterResource(id = R.drawable.smile),
                    contentDescription = "Send",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Gray
                )
            }





        }

        Box(
            modifier = Modifier
                .height(45.dp)
                .width(45.dp)
                .background(Color(0x2A377DFF), RoundedCornerShape(10.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier.size(30.dp),

                ) {
                Icon(
                    painter = painterResource(R.drawable.send),
                    contentDescription = "Send",
                    tint = Color(0xFF377DFF),
                )
            }
        }

    }

}






@Preview(showBackground = true, heightDp = 640, widthDp = 360)
@Composable
fun PostItemPreview() {
    PostItem()
}