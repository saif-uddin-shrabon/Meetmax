package com.lilab.meetmax.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lilab.meetmax.services.domain.AuthEvents
import com.lilab.meetmax.services.domain.AuthValidator
import com.lilab.meetmax.services.repository.FirebseAuthRepositoroy
import com.lilab.meetmax.services.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val firebaseAuthRepositoroy: FirebseAuthRepositoroy
) : ViewModel() {


    // Live data
    val loginResult = firebaseAuthRepositoroy.loginResultLiveData

    val registerResult = firebaseAuthRepositoroy.registerResultLiveData

    val forgetPasswordResult = firebaseAuthRepositoroy.forgetPasswordResultLiveData

    fun resetLiveData() {
        firebaseAuthRepositoroy._loginResultLiveData.value = null
        firebaseAuthRepositoroy._registerResultLiveData.value = null
        firebaseAuthRepositoroy._forgetPasswordResultLiveData.value = null
    }


    // Function to handle user events
    fun UserEventState(authEvents: AuthEvents) {
        when (authEvents) {
            is AuthEvents.OnLogin -> {
                val email = authEvents.email
                val password = authEvents.password
                val checked = authEvents.remember
                val result = AuthValidator.ValidateSigninRequest(email, password)
                if (result.successful) {
                    // Sign in function call for firebase authentication
                    viewModelScope.launch {
                        firebaseAuthRepositoroy.signInWithEmailAndPassword(email, password, checked)
                    }

                } else {
                    viewModelScope.launch {
                        // validation error
                        firebaseAuthRepositoroy._loginResultLiveData.postValue(NetworkResult.Error(result.error!!))
                    }
                }
            }

            is AuthEvents.OnRegister -> {
                val result = AuthValidator.validateCreateUserRequest(authEvents.creatUserData)
                if (result.successful) {
                    viewModelScope.launch {
                        // Sign up function call for firebase authentication
                        firebaseAuthRepositoroy.createUserWithEmailAndPassword(
                            authEvents.creatUserData
                        )
                    }
                } else {
                    viewModelScope.launch {
                        firebaseAuthRepositoroy._registerResultLiveData.postValue(NetworkResult.Error(result.error!!))
                    }
                }
            }
        }
    }

    fun forgetPassword(email: String) {
        viewModelScope.launch {
            firebaseAuthRepositoroy.forgetPassword(email)
        }
    }



}




