package com.snail.jetpackdemo.livedata_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    //Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy() {
        MutableLiveData<String>()
    }

    fun setValue(value: String) {
        currentName.value = value
    }

    fun postValue(value:String){
        currentName.postValue(value)
    }


}