package com.snail.jetpackdemo.workmanager_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.snail.jetpackdemo.R
import com.snail.jetpackdemo.databinding.ActivityWorkManagerBinding

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<UploadWork>().build()
        binding.tvWorkManager.setOnClickListener {
            WorkManager.getInstance(this).enqueue(uploadWorkRequest)
        }

    }
}