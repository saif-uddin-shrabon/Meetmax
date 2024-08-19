package com.lilab.meetmax.services.model

import kotlinx.serialization.Serializable


@Serializable
data class CreatUserData(
    val email: String? = "",
    val fullName: String? = "",
    val password: String? = "",
    val DOB: String? = "",
    val gender : String? = "",
    )