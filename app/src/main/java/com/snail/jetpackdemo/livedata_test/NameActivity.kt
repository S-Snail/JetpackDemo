package com.snail.jetpackdemo.livedata_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.snail.jetpackdemo.R
import com.snail.jetpackdemo.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
    private val model: NameViewModel by lazy {
        NameViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNameBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Create teh observer which updates the UI
        val nameObserver = Observer<String> { newName ->
            //Update the UI,in this case,a TextView
            if (newName == "") {
                binding.tvName.text = "testName"
            } else {
                binding.tvName.text = newName
            }
        }

        //Observe the LiveData,passing in this activity as the LifecycleOwner and observer
        model.currentName.observe(this, nameObserver)

        binding.btnSetNewName.setOnClickListener {
            model.setValue("张三")
        }

        binding.btnSetNewName2.setOnClickListener {
            model.postValue("李四")
        }

    }
}