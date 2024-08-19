package com.lilab.meetmax.services.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.getValue
import com.lilab.meetmax.services.model.CreatUserData
import com.lilab.meetmax.services.model.Response
import com.lilab.meetmax.services.utils.NetworkResult
import com.lilab.meetmax.services.utils.SharedPref
import com.lilab.meetmax.services.utils.SharedPref.getUserId
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
    val _forgetPasswordResultLiveData = MutableLiveData<NetworkResult<Response>>()



    val loginResultLiveData: LiveData<NetworkResult<FirebaseUser>>
        get() = _loginResultLiveData
    val registerResultLiveData: LiveData<NetworkResult<FirebaseUser>>
        get() = _registerResultLiveData

    val forgetPasswordResultLiveData: LiveData<NetworkResult<Response>>
        get() = _forgetPasswordResultLiveData



    // For creating user
      suspend fun createUserWithEmailAndPassword(
       creatUserData: CreatUserData
    ) {



        _registerResultLiveData.postValue(NetworkResult.Loading())

        try {


            val result = creatUserData.email?.let { creatUserData.password?.let { it1 ->
                firbaseAuth.createUserWithEmailAndPassword(it,
                    it1
                ).await()
            } }

            val user  = result!!.user



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
        password: String,
        remember: Boolean
    ) {
        _loginResultLiveData.postValue(NetworkResult.Loading())
        try {
            val result = firbaseAuth.signInWithEmailAndPassword(email, password).await()

            if (remember && result.user != null) {
                try {
                    val userId = result.user!!.uid

                    val userResponse = firebaseDatabase.database.getReference("Users").child(userId).get().await()

                    if (userResponse.exists()) {
                        val user = userResponse.getValue(CreatUserData::class.java)
                        if (user != null) {
                            user.fullName?.let { SharedPref.storeData(userId, it, context) }
                           // Log.d("UserPref", "CheckPref: ${getUserId(context)}")
                        }
                    }
                } catch (e: Exception) {
                    Log.e("FirebaseError", "Error fetching user data", e)
                }
            }

            _loginResultLiveData.postValue(NetworkResult.Success(result.user!!))

        }catch (
            e: Exception
        ){
            e.printStackTrace()
            _registerResultLiveData.postValue(NetworkResult.Error(e.localizedMessage) )

        }
    }


    //Forget Password
    suspend fun forgetPassword(email: String){
        _forgetPasswordResultLiveData.postValue(NetworkResult.Loading())
        try {
            firbaseAuth.sendPasswordResetEmail(email).await()
            _forgetPasswordResultLiveData.postValue(NetworkResult.Success(Response("Email sent successfully, Please check your email.")))

        }catch (e: Exception){
            e.printStackTrace()
            _forgetPasswordResultLiveData.postValue(NetworkResult.Error(e.localizedMessage) )
        }

    }

}