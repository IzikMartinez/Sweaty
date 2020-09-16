package com.example.sweaty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ToPlateActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plate_cal_activity)
    }
}

class ToWarmupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.warmup_activity)
    }
}
