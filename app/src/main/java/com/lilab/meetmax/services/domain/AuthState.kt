package com.lilab.meetmax.services.domain

import com.lilab.meetmax.services.model.CreatUserData

data class AuthState (
    val isLoading: Boolean = false
)

sealed class AuthEvents {
    data class OnLogin(val email: String, val password: String) : AuthEvents()
    data class OnRegister(val creatUserData: CreatUserData) : AuthEvents()
}

sealed class AuthResult {
    data class OnError(val message: String): AuthResult()
    data class OnSuccess(val message: String?): AuthResult()
}

data class ValidateResult(
    val successful: Boolean,
    val error: String? = null
)