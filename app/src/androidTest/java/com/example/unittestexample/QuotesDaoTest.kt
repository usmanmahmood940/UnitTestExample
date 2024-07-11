package com.example.unittestexample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuotesDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quotesDao: QuotesDao

    @Before
    fun setup(){
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quotesDao = quoteDatabase.quotesDao()

    }


    @Test
    fun insertQuote_expected_SingleQuote() = runBlocking{
        val quote = QuoteRoom(1,"text1","author1")
        quotesDao.insertQuote(quote)

        val quotes = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(1,quotes.size)
        assertEquals("text1",quotes[0].text)

    }


    @Test
    fun deleteQuote_expected_EmptyList() = runBlocking{
        val quote = QuoteRoom(1,"text1","author1")
        quotesDao.insertQuote(quote)
        quotesDao.delete()

        val quotes = quotesDao.getQuotes().getOrAwaitValue()

        assertEquals(0,quotes.size)
    }


    @After
    fun tearDown(){
        quoteDatabase.close()
    }
}