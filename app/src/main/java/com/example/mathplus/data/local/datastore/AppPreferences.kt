package com.example.mathplus.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AppPreferences(private val dataStore: DataStore<Preferences>){

    private val FIRST_TIME = booleanPreferencesKey("firstTime")
    private val ROUND = intPreferencesKey("round")
    private val DURATION = intPreferencesKey("duration")

    fun getFistTime() : Flow<Boolean> {
        return dataStore.data.map {
            it[FIRST_TIME] ?: false
        }
    }

    fun getRound() : Flow<Int>{
        return dataStore.data.map {
            it[ROUND] ?: 5
        }
    }

    fun getDuration() : Flow<Int>{
        return dataStore.data.map {
            it[DURATION] ?: 15000
        }
    }

    suspend fun setFirstTime(value : Boolean){
        dataStore.edit {
            it[FIRST_TIME] = value
        }
    }

    suspend fun setRoundDuration(round: Int, duration : Int){
        dataStore.edit {
            it[ROUND] = round
            it[DURATION] = duration
        }
    }

}