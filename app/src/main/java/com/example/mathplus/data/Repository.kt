package com.example.mathplus.data

import com.example.mathplus.data.local.datastore.AppPreferences
import com.example.mathplus.data.local.room.HistoryDao

class Repository(
    val dao : HistoryDao,
    val pref : AppPreferences
) {
}