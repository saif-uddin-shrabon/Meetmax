package com.lilab.meetmax.ViewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lilab.meetmax.services.local.MeetLocalDatabase
import com.lilab.meetmax.services.model.PostData
import com.lilab.meetmax.services.repository.CreatPostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val creatPostRepository: CreatPostRepository
) : ViewModel(){

    val postList : LiveData<List<PostData>> = creatPostRepository.todoList

    fun uploadPost(content : String, image : String){
       viewModelScope.launch {
           creatPostRepository.uploadPost(content, image)
       }
    }

    fun getAllPosts(){
        viewModelScope.launch {
            creatPostRepository.getAllPosts()
        }
    }


}