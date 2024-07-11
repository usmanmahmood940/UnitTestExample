package com.example.unittestexample.utils

import com.example.unittestexample.MainCoroutineRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UtilTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()


    @Test
    fun testGetUser(){
        val util= Util(mainCoroutineRule.testDispatcher)
//        runBlocking {  }
        runTest {
            util.changeAddress()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            assertEquals(true,util.globalArg)
        }
    }

}