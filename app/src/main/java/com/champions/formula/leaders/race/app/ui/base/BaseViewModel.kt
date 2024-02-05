package com.champions.formula.leaders.race.app.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T : Event> : ViewModel() {
    var event: MutableLiveData<Pair<Event, Any>> = MutableLiveData()
    var showProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun setProgress(isShow: Boolean){
        showProgress.value = isShow
    }

}