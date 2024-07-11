package com.example.unittestexample.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Util(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName():String{
        delay(10000)
        return "Usman"
    }

    suspend fun getUser():String{
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "User Usman"
    }

    suspend fun getAddress():String{
        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "Address"
    }

    var globalArg = false
    suspend fun changeAddress(){
        CoroutineScope(dispatcher).launch {
           globalArg = true
        }
    }

}