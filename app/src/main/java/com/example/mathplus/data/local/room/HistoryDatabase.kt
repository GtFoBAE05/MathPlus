package com.example.mathplus.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mathplus.data.local.model.HistoryModel

@Database(entities = [HistoryModel::class], version = 1, exportSchema = false,)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao() : HistoryDao

}