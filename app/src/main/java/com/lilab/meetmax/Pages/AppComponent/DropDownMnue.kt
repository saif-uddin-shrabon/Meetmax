package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme
@Composable
fun PostTypeChangeDropdownMenu(
    onOptionSelected: (Boolean) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Post") }

    Box {
        Row(
            modifier = Modifier
                .height(32.dp)
                .width(80.dp)
                .background(LightColorScheme.background, RoundedCornerShape(8.dp))
                .clickable { expanded = true },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedText,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                color = LightColorScheme.secondary,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = painterResource(id = R.drawable.angle_down),
                contentDescription = "Arrow Down",
                modifier = Modifier.size(12.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Event") },
                onClick = {
                    selectedText = "Event"
                    expanded = false
                    onOptionSelected(true)
                }
            )

            DropdownMenuItem(
                text = { Text("Post") },
                onClick = {
                    selectedText = "Post"
                    expanded = false
                    onOptionSelected(false)
                }
            )
        }
    }
}




@Preview(showBackground = true, heightDp = 640, widthDp = 360)
@Composable
fun DropDownMeny(){
    PostTypeChangeDropdownMenu(
        onOptionSelected = {
            // Handle option selection
        }
    )
}

