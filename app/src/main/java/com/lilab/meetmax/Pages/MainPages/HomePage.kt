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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AppComponent.NoPostFound
import com.lilab.meetmax.Pages.AppComponent.PostItem
import com.lilab.meetmax.Pages.AppComponent.PostSectionCard
import com.lilab.meetmax.Pages.AppComponent.SotrySection
import com.lilab.meetmax.Pages.AppComponent.StoryComponent
import com.lilab.meetmax.Pages.AppComponent.ToolbarSection
import com.lilab.meetmax.Pages.AppComponent.WarningDialog
import com.lilab.meetmax.R
import com.lilab.meetmax.ViewModel.AuthViewModel
import com.lilab.meetmax.ViewModel.PostViewModel
//import com.lilab.meetmax.ViewModel.PostViewModel
import com.lilab.meetmax.services.utils.NetworkResult
import com.lilab.meetmax.services.utils.SharedPref
import com.lilab.meetmax.ui.theme.LightColorScheme
import com.lilab.meetmax.ui.theme.MeetmaxTheme
import kotlinx.coroutines.launch

@Composable
fun HomePage(modifier: Modifier = Modifier, navHostController: NavHostController, postViewModel: PostViewModel) {



    // Fetching all posts
    postViewModel.getAllPosts()
    val posts by postViewModel.postList.observeAsState()

    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    var ShowPost by remember { mutableStateOf(false) }



    // Count of posts
    val postCount = posts?.size ?: 0
    if (postCount > 0) {
        ShowPost = true
    }


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
                        Spacer(modifier = Modifier.height(7.dp))

                        SotrySection()

                        Spacer(modifier = Modifier.height(7.dp))
                        PostSectionCard(navHostController)
                        if (!ShowPost){
                            NoPostFound()
                        }

                    }



                 if(ShowPost){
                     items(posts?.size ?: 0) { index ->
                         posts?.get(index)?.let { it1 ->
                             PostItem(
                                 content = it1.content,
                                 image = posts!![index].image
                             )

                         }

                     }

                 }


             }

             // Dialog for warning
             if(showDialog){
                 WarningDialog(
                     title = "Warning",
                     message = dialogMessage,
                     onConfirm = { showDialog = false }
                 )
             }




         }

   }

}



@OptIn(ExperimentalMaterial3Api::class)


@Preview(showBackground = true,  widthDp = 360, heightDp = 640, apiLevel = 33)
@Composable
fun HomePagePreview() {
//
     val mockNavController = rememberNavController()
   // val postViewModel = viewModel<PostViewModel>()
     //HomePage(navHostController = mockNavController)

}
