package com.example.unittestexample

import com.example.unittestexample.utils.Helper
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(val input:String, val expectedValue:Boolean) {

    @Test
    fun test(){
        val helper = Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expectedValue,result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome - {1}")
        fun data() : List<Array<Any>>{
            return listOf(
                arrayOf("hello",false),
                arrayOf("level",true),
                arrayOf("a",true),
                arrayOf("",true)
            )
        }
    }
}