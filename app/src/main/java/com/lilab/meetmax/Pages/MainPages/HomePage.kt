package com.lilab.meetmax.Pages.MainPages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AppComponent.PostItem
import com.lilab.meetmax.Pages.AppComponent.PostSectionCard
import com.lilab.meetmax.Pages.AppComponent.StoryComponent
import com.lilab.meetmax.Pages.AppComponent.ToolbarSection
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun HomePage(modifier: Modifier = Modifier, navHostController: NavHostController) {

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
                        ToolbarSection()
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow {
                            items(10) {
                                StoryComponent("https://picsum.photos/200/300")
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        PostSectionCard(navHostController)
                        Spacer(modifier = Modifier.height(10.dp))
                    }


                 items(10) {
                     PostItem()
                 }
             }




         }

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
//
     val mockNavController = rememberNavController()
   // HomePage()
}
