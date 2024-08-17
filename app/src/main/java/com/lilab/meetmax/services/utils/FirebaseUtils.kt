package com.lilab.meetmax.services.utils

import com.google.android.gms.tasks.Task
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun <T> Task<T>.await(): T {
    return suspendCoroutine { continuation ->
        addOnCompleteListener {
           if(it.exception != null){
               continuation.resumeWithException(it.exception!!)
           }else{
                continuation.resume(it.result!!)
           }
        }
    }
}
