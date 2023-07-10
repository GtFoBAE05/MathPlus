package com.example.mathplus.data.local.room

import androidx.room.Dao
import androidx.room.Query
import com.example.mathplus.data.local.model.HistoryModel

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history ORDER BY timeMillis DESC limit 5")
    fun getLastFiveHistory() : List<HistoryModel>

}