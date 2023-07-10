package com.example.mathplus.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.mathplus.data.Repository
import com.example.mathplus.data.local.datastore.AppPreferences
import com.example.mathplus.data.local.room.HistoryDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val AppModule = module {
    dbModule
    prefModule
    repositoryModule
}

val dbModule = module {
    single { Room.databaseBuilder(
        androidApplication(),
        HistoryDatabase::class.java,
        "history"
    ).build()
    }

    single { get<HistoryDatabase>().historyDao() }
}

val prefModule = module {
    single { AppPreferences(androidContext().dataStore) }
}

val repositoryModule = module{
    single { Repository(get(), get()) }
}