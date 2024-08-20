package com.lilab.meetmax.services.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.lilab.meetmax.services.model.StoryData
import com.lilab.meetmax.services.model.names

object StoryRepository {

    private val sotries = mutableStateOf<List<StoryData>>(emptyList())

    val _stories = ArrayList<StoryData>()

    private fun populateStories() {

        (0..9).forEach { index ->
            val story = StoryData(
                image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg",
                name = names[index]
            )
            _stories.add(story)
        }

        sotries.value = _stories
    }

    init {
        populateStories()
    }

    fun observeStories() : MutableState<List<StoryData>> = sotries
}