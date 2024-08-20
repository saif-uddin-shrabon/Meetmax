package com.lilab.meetmax.Pages.AppComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lilab.meetmax.services.repository.StoryRepository


@Composable
fun SotrySection(){
    val stories by StoryRepository.observeStories()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)

    ) {

        LazyRow {
            item {

                SingleStoryComponent("https://randomuser.me/api/portraits/men/${20}.jpg")

            }

            itemsIndexed(stories){index, item ->
                StoryComponent(imageUrl = item.image, item.name)
            }


        }

    }
}

@Preview(showBackground = true,  widthDp = 360, heightDp = 640)
@Composable
fun Sotry(){
    SotrySection()
}