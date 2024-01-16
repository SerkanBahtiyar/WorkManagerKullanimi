package com.example.workmanagerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanagerkullanimi.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonYap.setOnClickListener {
            val request = OneTimeWorkRequestBuilder<MyWorker>()
                .setInitialDelay(10,TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(this).enqueue(request)
        }

        binding.buttonBildirim.setOnClickListener {
            val request = PeriodicWorkRequestBuilder<MyWorkerBildirim>(15,TimeUnit.MINUTES)
                .setInitialDelay(10,TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(this).enqueue(request)
        }
    }
}