package com.lilab.meetmax.services.data

import com.google.firebase.auth.FirebaseUser


interface FirebseAuthPoint {
        suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseUser?
    suspend fun signInWithEmailAndPassword(email: String, password: String): FirebaseUser?
//    suspend fun checkUsernameAvailability(username: String): Boolean
//    suspend fun saveUserData(createUserData: CreatUserData): FirebaseUser?
}