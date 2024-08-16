package com.lilab.meetmax.Pages.Navigation

import kotlinx.serialization.Serializable


sealed class SubGraph{
    @Serializable
    data object Auth : SubGraph()
    @Serializable
    data object App : SubGraph()

}

sealed class Destination{
    @Serializable
    data object Login: Destination()
    @Serializable
    data object Signup: Destination()
    @Serializable
    data object ForgetPassword: Destination()
    @Serializable
    data object MainScreen: Destination()

    @Serializable
    data object  HomePage : Destination()



}