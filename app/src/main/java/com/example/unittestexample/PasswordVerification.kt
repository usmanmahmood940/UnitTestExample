package com.example.unittestexample

class PasswordVerification {

    fun isValidPassword(password: String): Boolean {

        if (password.length == 0 || password.length < 6 || password.length > 12) {
            return false
        }
        return true

    }
}