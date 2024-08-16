package com.lilab.meetmax.ViewModel.AuthVieModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.lilab.meetmax.services.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SigninViewModel @Inject constructor(private val authenticationRepository: AuthenticationRepository) : ViewModel() {

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()

    private val _state = MutableLiveData<SigninState>()
    val state: MutableLiveData<SigninState> = _state

    init {
        checkAuthStatus()
    }
    fun checkAuthStatus(){
        if(auth.currentUser==null){
            _state.value = SigninState.Unauthenticated
        }else{
            _state.value = SigninState.Authenticated
        }
    }


    // for input field validation
    fun ValidationCredintials(email: String, password: String) {


        if (email.isEmpty() || password.isEmpty()) {
            _state.value = SigninState.Error("Email or Password is required")

        }

        _state.value = SigninState.Loading
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{task->
                if (task.isSuccessful){
                    _state.value = SigninState.Authenticated
                }else{
                    _state.value = SigninState.Error(task.exception?.message?:"Something went wrong")
                }
            }

    }


    fun signup(email : String,password : String){

        if(email.isEmpty() || password.isEmpty()){
            _state.value = SigninState.Error("Email or password can't be empty")
            return
        }
        _state.value = SigninState.Loading
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{task->
                if (task.isSuccessful){
                    _state.value = SigninState.Authenticated
                }else{
                    _state.value = SigninState.Error(task.exception?.message?:"Something went wrong")
                }
            }
    }

    fun signout(){
        auth.signOut()
        _state.value = SigninState.Unauthenticated
    }


}

sealed class SigninState {

    object Authenticated : SigninState()
    object Unauthenticated : SigninState()
    object Loading : SigninState()
    object Success : SigninState()
    data class Error(val message: String) : SigninState()
}