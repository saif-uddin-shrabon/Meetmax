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

    // Channel to send events to the UI
//    private val _state = Channel<AuthResult>()
//    val stateFlow = _state.receiveAsFlow()


    // Live data
    val loginResult = firebaseAuthRepositoroy.loginResultLiveData

    val registerResult = firebaseAuthRepositoroy.registerResultLiveData





    var isLoading by mutableStateOf(false)
        private set


    // Function to handle user events
    fun UserEventState(authEvents: AuthEvents) {
        when (authEvents) {
            is AuthEvents.OnLogin -> {
                val email = authEvents.email
                val password = authEvents.password
                val result = AuthValidator.ValidateSigninRequest(email, password)
                if (result.successful) {
                    viewModelScope.launch {
                        firebaseAuthRepositoroy.signInWithEmailAndPassword(email, password)
                    }

                } else {
                    viewModelScope.launch {
                        firebaseAuthRepositoroy._loginResultLiveData.postValue(NetworkResult.Error(result.error!!))
                    }
                }
            }

            is AuthEvents.OnRegister -> {
                val result = AuthValidator.validateCreateUserRequest(authEvents.creatUserData)
                if (result.successful) {
                    viewModelScope.launch {
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

/*
    // Function to sign in user
    private fun SignIn(email: String, password: String) = viewModelScope.launch {
        isLoading = true

        val user = firebaseAuthPoint.signInWithEmailAndPassword(email, password)
        if (user != null) {

            isLoading = false
            _state.send(AuthResult.OnSuccess("Sign in successful"))
        } else {
            isLoading = false
            _state.send(AuthResult.OnError("Sign in failed"))
        }
    }


    // Function to create user
    private fun createUser(creatUserData: CreatUserData) = viewModelScope.launch {
        isLoading = true

        try {
                firebaseAuthPoint.createUserWithEmailAndPassword(
                    creatUserData.email,
                    creatUserData.password
                )


             isLoading = false
                _state.send(AuthResult.OnSuccess("User created successfully"))

        } catch (e: Exception) {
            isLoading = false
            _state.send(AuthResult.OnError("Unable to create user, try again"))
        }
    }

    */
}




