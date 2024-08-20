package com.lilab.meetmax.services.repository

import android.net.Network
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lilab.meetmax.services.local.MeetLocalDatabase
import com.lilab.meetmax.services.model.PostData
import com.lilab.meetmax.services.utils.NetworkResult
import javax.inject.Inject

class CreatPostRepository @Inject constructor(
  private val meetLocalDatabase: MeetLocalDatabase
){

    private var _todoList = MutableLiveData<List<PostData>>()
    val todoList : LiveData<List<PostData>> = _todoList


    suspend fun uploadPost(content : String, image : String, title: String, postType: Boolean){
        meetLocalDatabase.postDao().insertPost(PostData(content = content, image = image, title = title, postType = postType))
    }

    fun getAllPosts(){
        meetLocalDatabase.postDao().getAllPosts().observeForever {
            _todoList.postValue(it)
        }
    }





}