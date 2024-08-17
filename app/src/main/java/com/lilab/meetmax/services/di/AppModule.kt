package com.lilab.meetmax.services.di

import com.google.firebase.auth.FirebaseAuth
import com.lilab.meetmax.services.data.FirebseAuthPoint
import com.lilab.meetmax.services.repository.FirebseAuthRepositoroy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideFirebseAuth(): FirebaseAuth = FirebaseAuth.getInstance()


    @Provides
    fun provideAuthRepository(impl : FirebseAuthRepositoroy): FirebseAuthPoint = impl
}