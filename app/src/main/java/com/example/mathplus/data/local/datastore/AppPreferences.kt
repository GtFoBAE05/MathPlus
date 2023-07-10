package com.example.mathplus.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AppPreferences(private val dataStore: DataStore<Preferences>){

    private val FIRST_TIME = booleanPreferencesKey("firstTime")

    fun getFistTime() : Flow<Boolean> {
        return dataStore.data.map {
            it[FIRST_TIME] ?: false
        }
    }

    suspend fun setFirstTime(value : Boolean){
        dataStore.edit {
            it[FIRST_TIME] = value
        }
    }

}