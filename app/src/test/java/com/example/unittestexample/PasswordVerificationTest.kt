package com.example.unittestexample

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class PasswordVerificationTest {

    lateinit var passwordVerification: PasswordVerification
    @Before
    fun setUp() {
        passwordVerification = PasswordVerification()
    }

    @Test
    fun isValidPassword_expected_Incrorrect() {
        val check = passwordVerification.isValidPassword("")
        assertEquals(false,check)
    }

    @Test
    fun isValidPassword_expected_Correct() {
        val check = passwordVerification.isValidPassword("123456")
        assertEquals(true,check)
    }
}