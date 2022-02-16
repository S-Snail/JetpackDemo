package com.snail.jetpackdemo.viewmodel_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.snail.jetpackdemo.databinding.ActivityViewModelBinding
import kotlinx.coroutines.launch

class ViewModelActivity : AppCompatActivity() {
    private val TAG = "Test_ViewModel"

    init {
        lifecycleScope.launch {
            whenStarted {
                try {
                    Log.d(TAG,"whenStarted()")
                } finally {
                    Log.d(TAG,"执行Finally Block")
                }
            }
            whenCreated {

            }
            whenResumed {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val model = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory.instance
        )[MyViewModel::class.java]

        model.getUsers().observe(this, Observer<List<User>> { users ->
            Toast.makeText(this, "Update UI", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Update UI")
            binding.tvViewModel.text = "Update UI"
        })

        Log.d("Test_ViewModel", model.hashCode().toString())

        this.lifecycleScope.launch {
            Thread {
                Thread.sleep(4000)
                Log.d(TAG, "在此范围内启动的协程会在Lifecycle被销毁时取消")
            }.start()
        }

    }
}