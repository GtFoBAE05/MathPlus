package com.example.mathplus.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo
    val timeMillis : String,

    @ColumnInfo
    val score : Int
)