package com.example.unittestexample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class FirstActivityTest{

    @get:Rule
    val acitivityScenarioRule = ActivityScenarioRule(FirstActivity::class.java)

    @Test
    fun testSubmitButton_expectedCorrectValues(){
        onView(withId(R.id.etTitle)).perform(typeText("Hello Usman How are you?"), closeSoftKeyboard())

        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(withText("Hello Usman How are you?")))
    }

}