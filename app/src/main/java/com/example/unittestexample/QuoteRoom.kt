package com.example.unittestexample

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteRoom(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val text:String,
    val author:String
)
