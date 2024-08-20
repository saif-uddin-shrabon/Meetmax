package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.lilab.meetmax.Pages.Navigation.Destination
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme

// Create Event Post
@Composable
fun CreatEventPostContent(
    textValue: String,
    titleOfHeadingEvent : String,
    onTitleChange: (String) -> Unit = {},
    onContentChange: (String) -> Unit = {}
){
    var isEnabledTitle by remember { mutableStateOf(false) }
    var isEnabledContent by remember { mutableStateOf(false) }




    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()

    ) {

        BasicTextFiledWithHint(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 5.dp),
            hint = "Event Title",
            value = titleOfHeadingEvent,
            onValueChange = {
                onTitleChange(it)
                isEnabledTitle = true
            },

            isEnabled = {
                isEnabledTitle = it
            }
        )

        Spacer(modifier = Modifier.height(8.dp))
        BasicTextFiledWithHint(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 5.dp),
            hint = "What's happening?",
            value = textValue,
            onValueChange = {
                onContentChange(it)
                isEnabledContent = true
            },

            isEnabled = {
                isEnabledContent = it
            }
        )


    }
}




@Preview(showBackground = true, heightDp = 640, widthDp = 360)
@Composable
fun CreatEventPostPreview(){
    CreatEventPostContent(textValue = "Hello", titleOfHeadingEvent = "Event Title")
}