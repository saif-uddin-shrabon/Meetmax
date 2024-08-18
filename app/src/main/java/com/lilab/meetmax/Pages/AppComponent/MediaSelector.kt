package com.lilab.meetmax.Pages.AppComponent

import android.content.Context
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.lilab.meetmax.R
import com.lilab.meetmax.services.utils.PermissionManager


@Composable
fun MediaSelector(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    imageUri: Uri?,
    videoUri: Uri?,
    onImageSelected: (Uri?) -> Unit,
    permissions:List<String>,
    imageLauncher: ManagedActivityResultLauncher<String, Uri?>,
    permissionLauncher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>
) {
    if (imageUri == null && videoUri == null) {
        Column(
            modifier = modifier,
           verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,


            ) {
                Icon(
                    painter = painterResource(id = R.drawable.video_camera),
                    contentDescription = "Live",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Lieve",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier =  Modifier.height(8.dp) )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    val isGranted = PermissionManager.checkPermissionGranted(context, permissions)
                    if (isGranted) {
                        imageLauncher.launch("image/*")
                    } else {
                        PermissionManager.requestPermissions(permissionLauncher, permissions)
                    }
                }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.picture),
                    contentDescription = "Picture",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Photo/Video",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier =  Modifier.height(8.dp) )

            Row(
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.smile),
                    contentDescription = "Feelings",
                    modifier = Modifier.size(16.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Feelings",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }


        }
    }
    else {
        when {

            imageUri != null -> {
                Box(
                    modifier = Modifier
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .shadow(0.dp, shape = RoundedCornerShape(8.dp))
                ) {
                    Image(
                        modifier = Modifier
                            .defaultMinSize(minHeight = 100.dp, minWidth = 1.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(context)
                                .data(imageUri)
                                .size(Size.ORIGINAL)
                                .crossfade(true)
                                .build(),
                        ),
                        contentDescription = "image",
                        contentScale = ContentScale.Fit
                    )
                    IconButton(
                        modifier = Modifier.align(Alignment.TopEnd),
                        onClick = { onImageSelected(null) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Cancel,
                            contentDescription = "Remove image",
                            tint = Color.LightGray
                        )
                    }
                }
            }


        }
    }
}
@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun AddThreadScreenPrevielw() {



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

