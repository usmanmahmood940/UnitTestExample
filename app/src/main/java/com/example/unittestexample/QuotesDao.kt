package com.example.unittestexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuote(quoteRoom: QuoteRoom)

    @Update
    suspend fun updateQuote(quoteRoom: QuoteRoom)

    @Query("DELETE FROM QuoteRoom")
    suspend fun delete()

    @Query("SELECT * FROM QuoteRoom")
    fun getQuotes(): LiveData<List<QuoteRoom>>

    @Query("SELECT * FROM QuoteRoom WHERE id = :quoteId")
    fun getQuotesById(quoteId:Int):QuoteRoom

}