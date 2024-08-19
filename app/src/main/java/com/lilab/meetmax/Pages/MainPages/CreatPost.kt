package com.lilab.meetmax.Pages.MainPages

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AppComponent.BasicTextFiledWithHint
import com.lilab.meetmax.Pages.AppComponent.CustomButton
import com.lilab.meetmax.Pages.AppComponent.MediaSelector
import com.lilab.meetmax.Pages.AppComponent.ToolbarSection
import com.lilab.meetmax.Pages.Navigation.Destination
import com.lilab.meetmax.R
import com.lilab.meetmax.services.utils.PermissionManager
import com.lilab.meetmax.ui.theme.LightColorScheme

@Composable
fun CreatPost(navHostController: NavHostController) {



    Surface(

        modifier = Modifier.fillMaxSize()
    ) {
       Column(
              modifier = Modifier.fillMaxSize()
                  .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
              horizontalAlignment = Alignment.CenterHorizontally
       ) {
           ToolbarSection()

           CreatePostScreen(navHostController)
       }
    }
}

@Composable
fun CreatePostScreen(navHostController: NavHostController){


     Column(
            modifier =  Modifier.padding(start = 10.dp, end = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
     ) {
            Spacer(modifier = Modifier.height(8.dp))
            HeadingSectionOfCreatPost(navHostController)

             Divider(
                 color = Color.Gray,
                 thickness = 1.dp,
                 modifier = Modifier.fillMaxWidth()
             )
            Spacer(modifier = Modifier.height(15.dp))
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
fun HeadingSectionOfCreatPost(navHostController: NavHostController){

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


            Row(
                modifier = Modifier
                    .height(32.dp)
                    .width(80.dp)
                    .background(LightColorScheme.background, RoundedCornerShape(8.dp)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Friends",
                    fontSize = 12.sp,
                    color = LightColorScheme.secondary,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.angle_down),
                    contentDescription = "Arrow Down",
                    modifier = Modifier
                        .size(12.dp)
                )

            }

        Spacer(modifier = Modifier.width(8.dp))


    }
}



@Composable
fun PostContent(){
    var isEnabled by remember { mutableStateOf(false) }
    var textValue by remember { mutableStateOf("") }
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
                textValue = it
                isEnabled = true
            },

            isEnabled = {
                isEnabled = it
            }
        )


    }
}


@Composable
fun ActionPerformer(){


    val context = LocalContext.current

    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var videoUri by remember { mutableStateOf<Uri?>(null) }

    val permissions = PermissionManager.getPermissionRequest()
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? -> imageUri = uri }
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
        onImageSelected = { imageUri = it },
        permissions = permissions,
        imageLauncher = launcher,
        permissionLauncher = permissionLauncher
    )





}




@Preview(showBackground = true, heightDp = 650, widthDp = 360)
@Composable
fun CreatPostPreview() {
    val mockNavController = rememberNavController()
    CreatPost(mockNavController)
}