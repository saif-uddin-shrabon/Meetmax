package com.lilab.meetmax.ViewModel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lilab.meetmax.services.repository.CreatPostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatPostViewModel @Inject constructor(private val creatPostRepository: CreatPostRepository) : ViewModel(){

    fun uploadPost(content: String, image: Uri?){
       viewModelScope.launch {
           creatPostRepository.uploadPost(content, image)
       }
    }
}