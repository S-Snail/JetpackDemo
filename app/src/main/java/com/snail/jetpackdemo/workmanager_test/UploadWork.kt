package com.snail.jetpackdemo.workmanager_test

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * 第一步，定义Work工作单元
 * 第二步，使用WorkRequest（及其子类），定义工作运行方式和时间
 * 第三步，使用enqueue()方法将WorkRequest提交到WorkManager
 * 创建需要上传图片的Worker
 */
class UploadWork(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        //Do the work here -- in this case ,upload the image
        uploadImages()
        return Result.success()
    }

    private fun uploadImages() {


    }
}