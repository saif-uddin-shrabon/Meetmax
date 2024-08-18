package com.lilab.meetmax.services.repository

import android.net.Uri
import javax.inject.Inject

class CreatPostRepository @Inject constructor(

){
    suspend fun uploadPost(content: String, image: Uri?){
        // upload post to firebase
    }

}