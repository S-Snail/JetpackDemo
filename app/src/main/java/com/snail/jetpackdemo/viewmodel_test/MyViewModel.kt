package com.snail.jetpackdemo.viewmodel_test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val TAG = "Test_ViewModel"

    init {
        viewModelScope.launch {
            //Coroutine that will be canceled when the ViewModel is cleared
            Thread{
                Thread.sleep(5000)
                Log.d(TAG,"协程在ViewModel被清除时取消")
            }.start()
        }
    }

    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    private fun loadUsers() {
        Log.d(TAG, "loadUsers()")
        // Do an asynchronous operation to fetch users
        Thread {
            Thread.sleep(3000)
            val userList = ArrayList<User>()
            userList.add(User("1", "张三", "男"))
            userList.add(User("2", "李四", "男"))
            userList.add(User("3", "王二", "男"))
            users.postValue(userList)
        }.start()
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }
}