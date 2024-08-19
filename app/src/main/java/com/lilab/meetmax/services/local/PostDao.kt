package com.lilab.meetmax.services.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lilab.meetmax.services.model.PostData
import kotlinx.coroutines.flow.Flow


@Dao
interface PostDao {

    @Insert
    suspend fun insertPost(postData: PostData)
    @Query("SELECT * FROM PostData")
    fun getAllPosts(): LiveData<List<PostData>>
}