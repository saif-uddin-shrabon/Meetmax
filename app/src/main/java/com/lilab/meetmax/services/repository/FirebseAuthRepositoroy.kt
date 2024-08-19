package com.lilab.meetmax.services.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.lilab.meetmax.services.model.CreatUserData
import com.lilab.meetmax.services.utils.NetworkResult
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebseAuthRepositoroy @Inject constructor (
    private val firbaseAuth: FirebaseAuth,
    private val firebaseDatabase: DatabaseReference,
    @ApplicationContext val context: android.content.Context,
)  {

     val _loginResultLiveData = MutableLiveData<NetworkResult<FirebaseUser>>()
     val _registerResultLiveData = MutableLiveData<NetworkResult<FirebaseUser>>()

    val loginResultLiveData: LiveData<NetworkResult<FirebaseUser>>
        get() = _loginResultLiveData
    val registerResultLiveData: LiveData<NetworkResult<FirebaseUser>>
        get() = _registerResultLiveData



    // For creating user
      suspend fun createUserWithEmailAndPassword(
       creatUserData: CreatUserData
    ) {



        _registerResultLiveData.postValue(NetworkResult.Loading())

        try {


            val result = firbaseAuth.createUserWithEmailAndPassword(creatUserData.email, creatUserData.password).await()

            val user  = result.user


               firebaseDatabase.child("Users").child(user?.uid.toString()).setValue(creatUserData)




            _registerResultLiveData.postValue(NetworkResult.Success(result.user!!))


        }catch (
            e: Exception
        ){
            e.printStackTrace()
            _registerResultLiveData.postValue(NetworkResult.Error(e.localizedMessage) )
        }
    }


    // For signing in user
     suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ) {
        _loginResultLiveData.postValue(NetworkResult.Loading())
        try {
            val result = firbaseAuth.signInWithEmailAndPassword(email, password).await()

            _loginResultLiveData.postValue(NetworkResult.Success(result.user!!))

        }catch (
            e: Exception
        ){
            e.printStackTrace()
            _registerResultLiveData.postValue(NetworkResult.Error(e.localizedMessage) )

        }
    }

}