package com.lilab.meetmax.services.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.lilab.meetmax.services.data.FirebseAuthPoint
import com.lilab.meetmax.services.utils.await
import javax.inject.Inject

class FirebseAuthRepositoroy @Inject constructor (
    private val firebseendEndPoint: FirebaseAuth
) : FirebseAuthPoint {

    // For creating user
    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): FirebaseUser? {
        try {
            val result = firebseendEndPoint.createUserWithEmailAndPassword(email, password).await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName("User").build())
            return result.user
        }catch (
            e: Exception
        ){
            e.printStackTrace()
            return null
        }
    }


    // For signing in user
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): FirebaseUser? {
        try {
            val result = firebseendEndPoint.signInWithEmailAndPassword(email, password).await()
            return result.user
        }catch (
            e: Exception
        ){
            e.printStackTrace()
            return null
        }
    }

//    override suspend fun checkUsernameAvailability(username: String): Boolean {
//
//    }
//
//    override suspend fun saveUserData(createUserData: CreatUserData): FirebaseUser? {
//
//    }
}