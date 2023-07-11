package com.example.mathplus.data

import com.example.mathplus.data.local.datastore.AppPreferences
import com.example.mathplus.data.local.room.HistoryDao
import java.time.Duration

class Repository(
    val dao : HistoryDao,
    val pref : AppPreferences
) {

    fun getFirstTime() = pref.getFistTime()

    fun getRound() = pref.getRound()

    fun getDuration() = pref.getDuration()


    suspend fun setFirstTime(value : Boolean){
        pref.setFirstTime(value)
    }

    suspend fun setRoundDuration(round: Int, duration : Int){
        pref.setRoundDuration(round, duration)
    }


}