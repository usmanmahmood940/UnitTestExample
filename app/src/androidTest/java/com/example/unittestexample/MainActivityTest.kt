package com.example.unittestexample


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    @get:Rule
    val acitivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNextButton_expectedCorrectQuote(){
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.quoteText)).check(matches(withText("Success is not final, failure is not fatal: It is the courage to continue that counts.")))

    }
}