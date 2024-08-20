package com.lilab.meetmax.Pages.MainPages

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.lilab.meetmax.Pages.AppComponent.BasicTextFiledWithHint
import com.lilab.meetmax.Pages.AppComponent.CreatEventPostContent
import com.lilab.meetmax.Pages.AppComponent.CustomDevider
import com.lilab.meetmax.Pages.AppComponent.MediaSelector
import com.lilab.meetmax.Pages.AppComponent.PostTypeChangeDropdownMenu
import com.lilab.meetmax.Pages.AppComponent.ToolbarSection
import com.lilab.meetmax.Pages.Navigation.Destination
import com.lilab.meetmax.R
import com.lilab.meetmax.ViewModel.PostViewModel
import com.lilab.meetmax.services.model.PostData
import com.lilab.meetmax.services.utils.PermissionManager
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun CreatPost(navHostController: NavHostController,postViewModel: PostViewModel) {


    Surface(

        modifier = Modifier.fillMaxSize()
    ) {
       Column(
              modifier = Modifier
                  .fillMaxSize()
                  .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
              horizontalAlignment = Alignment.CenterHorizontally
       ) {
           ToolbarSection()

           CreatePostScreen(navHostController, postViewModel)
       }
    }
}

@Composable
fun CreatePostScreen(navHostController: NavHostController,postViewModel: PostViewModel){


    var textValue by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    var event by remember { mutableStateOf(false) }


     Column(
            modifier =  Modifier.padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
     ) {
            Spacer(modifier = Modifier.height(8.dp))


         HeadingSectionOfCreatPost(navHostController,onEventChange = { event = it })
           CustomDevider()
         if (!event) {
             PostContent(
                 navHostController,
                 textValue = textValue,
                 onTextChager = { textValue = it })
         }else{
             CreatEventPostContent(textValue = textValue, onTextChager = { textValue = it })
         }



            Spacer(modifier = Modifier.height(8.dp))
            ActionPerformer(imageUri = imageUri, onImageSelected = { imageUri = it })
           Spacer(modifier = Modifier.height(18.dp) )

           AnimatedVisibility(!isLoading) {
             Button(
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(53.dp),
                 shape = RoundedCornerShape(7.dp),
                 colors = ButtonDefaults.buttonColors(
                     containerColor = LightColorScheme.primary,
                     contentColor = Color.White
                 ),
                 onClick = {
                     Log.d("PostIMG", imageUri.toString())
                    postViewModel.uploadPost(textValue, imageUri.toString())

                     // Clearing the text and image after post
                        textValue = ""
                        imageUri = null
                     navHostController.navigate(Destination.MainScreen) {
                         popUpTo(Destination.MainScreen) {
                             inclusive = true
                         }
                     }
                 },
             ) {
                 Text(
                     modifier = Modifier.padding(vertical = 5.dp),
                     text = "Post",
                     fontSize = 16.sp
                 )
             }

         }

         if (isLoading) {
             Spacer(modifier = Modifier.height(5.dp))
             CircularProgressIndicator(
                 modifier = Modifier.align(Alignment.CenterHorizontally),
                 color = Color.Black,
             )
         }

     }

}

// Heading Section of Create Post
@Composable
fun HeadingSectionOfCreatPost(navHostController: NavHostController, onEventChange: (Boolean) -> Unit){


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Icon(
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = "Arrow Back",
            modifier = Modifier
                .size(20.dp)
                .clickable {
                    navHostController.navigate(Destination.MainScreen) {
                        popUpTo(Destination.MainScreen) {
                            inclusive = true
                        }
                    }

                }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Creat a Post",
            fontSize = 18.sp,
             fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
            color = LightColorScheme.tertiary
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Visible for",
            fontSize = 12.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.width(8.dp))

        PostTypeChangeDropdownMenu(
            onOptionSelected = {

                onEventChange(it)
            }

        )



        Spacer(modifier = Modifier.width(8.dp))


    }
}


// Post Content
@Composable
fun PostContent(navHostController: NavHostController,textValue: String, onTextChager: (String) -> Unit = {}){
    var isEnabled by remember { mutableStateOf(false) }



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
            BasicTextFiledWithHint(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 5.dp),
                hint = "What's happening?",
                value = textValue,
                onValueChange = {
                    onTextChager(it)
                    isEnabled = true
                },

                isEnabled = {
                    isEnabled = it
                }
            )


        }


}



@Composable
fun ActionPerformer(
    imageUri: Uri?,
    onImageSelected: (Uri?) -> Unit){
    val videoUri: Uri? = null


    val context = LocalContext.current

    val permissions = PermissionManager.getPermissionRequest()
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        onImageSelected(it)
    }
    val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
        val allGranted = permission.all { it.value }
        if (allGranted) {
            launcher.launch("image/*")
        } else {
            Toast.makeText(context, "Permissions Not Granted!! Please grant permissions", Toast.LENGTH_SHORT).show()
        }
    }



    MediaSelector(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        context = context,
        imageUri = imageUri,
        videoUri = videoUri,
         onImageSelected = { onImageSelected(it)},
        permissions = permissions,
        imageLauncher = launcher,
        permissionLauncher = permissionLauncher
    )





}




@Preview(showBackground = true, heightDp = 650, widthDp = 360)
@Composable
fun CreatPostPreview() {
    val mockNavController = rememberNavController()
    //CreatPost(mockNavController)
}