package com.snail.jetpackdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snail.jetpackdemo.databinding.ActivityMainBinding
import com.snail.jetpackdemo.lifecycle_test.MyObserver
import com.snail.jetpackdemo.livedata_test.NameActivity
import com.snail.jetpackdemo.viewmodel_test.ViewModelActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.lifecycle.addObserver(MyObserver())
        binding.tvHelloWord.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }
    }
}