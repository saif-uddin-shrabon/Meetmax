package com.lilab.meetmax.services.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.lilab.meetmax.services.local.MeetLocalDatabase
import com.lilab.meetmax.services.local.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideFirebseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFirebaseDatabase(): DatabaseReference
            = FirebaseDatabase.getInstance().reference


    @Singleton
    @Provides
    fun provideMeeetLocalDatabase(@ApplicationContext context: Context) =
        MeetLocalDatabase.getInstance(context)

    @Singleton
    @Provides
    fun providePostDao(meetLocalDatabase: MeetLocalDatabase) : PostDao{
        return meetLocalDatabase.postDao()
    }


}