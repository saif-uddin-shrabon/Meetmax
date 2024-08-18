package com.lilab.meetmax.Pages.MainPages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilab.meetmax.Pages.AppComponent.PostItem
import com.lilab.meetmax.Pages.AppComponent.PostSectionCard
import com.lilab.meetmax.Pages.AppComponent.StoryComponent
import com.lilab.meetmax.R.drawable
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun HomePage(modifier: Modifier = Modifier) {

    val state = rememberScrollState()
   Scaffold {it ->
         Column(
              modifier = modifier
                  .padding(it)
                  .background(LightColorScheme.background),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally
         ) {

             LazyColumn {
                    item{
                        Toolbar()
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow {
                            items(10) {
                                StoryComponent("https://picsum.photos/200/300")
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        PostSectionCard()
                        Spacer(modifier = Modifier.height(10.dp))
                    }


                 items(10) {
                     PostItem()
                 }
             }




         }

   }

}

@Composable
private fun Toolbar() {
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
                painter = painterResource(id = com.lilab.meetmax.R.drawable.message),
                contentDescription = "Angle Down Icon",
                Modifier
                    .size(24.dp)

            )

        }

        Spacer(modifier = Modifier.width(5.dp))


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){


        OutlinedTextField(
            modifier = Modifier
                .height(50.dp)
                .width(250.dp),
            value = "",
            onValueChange = {},
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    Modifier.size(18.dp)
                )
            },
            placeholder = {
                Text(

                    text = stringResource(id = R.string.SearchPlaceholder),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                )
            },

        )



}

@Preview(showBackground = true,  widthDp = 360, heightDp = 640)
@Composable
fun HomePagePreview() {
    HomePage()
}
