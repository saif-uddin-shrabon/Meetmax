package com.lilab.meetmax.Pages.Navigation

import kotlinx.serialization.Serializable

sealed class Destination{
    @Serializable
    data object Login: Destination()
    @Serializable
    data object Signup: Destination()
    @Serializable
    data object ForgetPassword: Destination()
    @Serializable
    data object Home: Destination()
}