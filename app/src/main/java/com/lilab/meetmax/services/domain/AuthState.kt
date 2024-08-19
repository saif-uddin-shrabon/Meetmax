package com.lilab.meetmax.services.domain

import com.lilab.meetmax.services.model.CreatUserData

data class AuthState (
    val isLoading: Boolean = false
)

sealed class AuthEvents {
    data class OnLogin(val email: String, val password: String, val remember : Boolean) : AuthEvents()
    data class OnRegister(val creatUserData: CreatUserData) : AuthEvents()
}


data class ValidateResult(
    val successful: Boolean,
    val error: String? = null
)