package com.example.rpwg.PopularSearches

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Date

object GlobalTimer {

    // Flow
    // SharedFlow
    // StateFlow

    private var _currentTimeEvent = MutableSharedFlow<Date>()
    var currentTimeEvent = _currentTimeEvent.asSharedFlow()

//    var currentTimeEvent = MutableSharedFlow<Date>()

    var timerJob : Job? = null

    fun startTimer(){

        this.timerJob?.cancel()
        this.timerJob = null

        this.timerJob = GlobalScope.launch {
            while (this.isActive){
                delay(1000)
                _currentTimeEvent.emit(Date())
            }
        }
    }

    fun stopTimer(){
        timerJob?.cancel()
        timerJob = null
    }
}