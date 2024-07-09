package com.example.unittestexample

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

//    @Before
//    fun setUp() {
//
//    }
//
//    @After
//    fun tearDown() {
//
//    }

    //Assert
    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        //Arrange
        val quoteManager  = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Act
        quoteManager.populateQuoteFromAssets(context,"")
        // Assert
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Exception() {
        //Arrange
        val quoteManager  = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Act
        quoteManager.populateQuoteFromAssets(context,"malformed.json")
        // Assert
    }

    @Test
    fun testPopulateQuoteFromAssets_ValidJSON_expected_Count() {
        //Arrange
        val quoteManager  = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        // Act
        quoteManager.populateQuoteFromAssets(context,"quotes.json")
        // Assert
        assertEquals(10,quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager  = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("text1","1"),
                Quote("text2","2"),
                Quote("text3","3")
            )
        )
        // Act
       val quote =  quoteManager.getPreviousQuote()
        // Assert
        assertEquals("1",quote.author)
    }

    @Test
    fun testNextQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager  = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("text1","1"),
                Quote("text2","2"),
                Quote("text3","3")
            )
        )
        // Act
        val quote =  quoteManager.getNextQuote()
        // Assert
        assertEquals("2",quote.author)
    }
}