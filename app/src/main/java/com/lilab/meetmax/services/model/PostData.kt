package com.lilab.meetmax.services.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "PostData")
data class PostData (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,

    val content : String,
    val image : String,
    val title: String,
    val postType: Boolean,
)