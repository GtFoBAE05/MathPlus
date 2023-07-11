package com.example.mathplus.ui.setting

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mathplus.data.Repository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SettingViewModel(private val repository: Repository) : ViewModel() {

    private var _round = MutableLiveData<Int>()
    val round : LiveData<Int> = _round

    private var _duration = MutableLiveData<Int>()
    val duration : LiveData<Int> = _duration

    init {
        getRound()
        getDuration()
    }


    private fun getRound(){
        viewModelScope.launch {
            repository.getRound().collect{
                _round.value = it
            }
        }
    }

    private fun getDuration(){
        viewModelScope.launch {
            repository.getDuration().collect{
                _duration.value = it/1000
            }
        }
    }

    fun saveChanges(round : Int, duration: Int){
        viewModelScope.launch{
            Log.e(ContentValues.TAG, "duration $duration / round $round", )

            repository.setRoundDuration(round, duration)
        }
    }



}