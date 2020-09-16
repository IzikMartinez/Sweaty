package com.example.sweaty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val plateButton = findViewById<Button>(R.id.toPlateButton)
        plateButton?.setOnClickListener {
            startActivity(Intent(this, ToPlateActivity::class.java))
        }

        val warmupButton = findViewById<Button>(R.id.warmupButton)
        warmupButton?.setOnClickListener {
            startActivity(Intent(this, ToWarmupActivity::class.java))
        }


    }
}