package com.lilab.meetmax.services.domain
import com.lilab.meetmax.services.model.CreatUserData
import java.util.regex.Pattern

object AuthValidator {
    
        fun validateCreateUserRequest(createUserData: CreatUserData): ValidateResult {
            val username = createUserData.fullName
            val password = createUserData.password
            val email = createUserData.email
            val fullName = createUserData.fullName
            val DOB = createUserData.DOB
            val gender = createUserData.gender
    
            if (username!!.isBlank() && password!!.isBlank() && email!!.isBlank() && fullName!!.isBlank()) {
                return ValidateResult(
                    successful = false,
                    error = "All fields are empty"
                )
            }
            if (email!!.isBlank()) {
                return ValidateResult(
                    successful = false,
                    error = "Email cannot be blank"
                )
            }
            if (email.isNotBlank()) {
                val EMAIL_REGEX = Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                            "\\@" +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                            "(" +
                            "\\." +
                            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                            ")+"
                )
                val matches = EMAIL_REGEX.matcher(email).matches()
                if (!matches) {
                    return ValidateResult(
                        successful = false,
                        error = "Email is not valid"
                    )
                }
            }
            if (fullName!!.isBlank()) {
                return ValidateResult(
                    successful = false,
                    error = "FullName cannot be blank"
                )
            }
            if (username.isBlank()) {
                return ValidateResult(
                    successful = false,
                    error = "Username cannot be blank"
                )
            }
            if (password!!.isBlank()) {
                return ValidateResult(
                    successful = false,
                    error = "Password cannot be blank"
                )
            }
            if (DOB!!.isBlank()) {
                return ValidateResult(
                    successful = false,
                    error = "DOB cannot be blank"
                )
            }
            if (gender!!.isBlank()) {
                return ValidateResult(
                    successful = false,
                )
            }
            return ValidateResult(successful = true)
        }



    fun ValidateSigninRequest(email: String, password: String): ValidateResult {
        if (email.isBlank() && password.isBlank()) {
            return ValidateResult(
                successful = false,
                error = "Email and password cannot be blank"
            )
        }
        if (email.isBlank()) {
            return ValidateResult(
                successful = false,
                error = "Email field cannot be blank"
            )
        }
        if (email.isNotBlank()) {
            val EMAIL_REGEX = Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+"
            )
            val matches = EMAIL_REGEX.matcher(email).matches()
            if (!matches) {
                return ValidateResult(
                    successful = false,
                    error = "Email is not valid"
                )
            }
        }
        if (password.isBlank()) {
            return ValidateResult(
                successful = false,
                error = "Password field cannot be blank"
            )
        }
        return ValidateResult(successful = true)
    }


}