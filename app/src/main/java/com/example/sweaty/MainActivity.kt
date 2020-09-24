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

        val bodybuildingButton = findViewById<Button>(R.id.toExerciseButton)
        bodybuildingButton?.setOnClickListener {
            startActivity(Intent(this, ToBodybuildingActivity::class.java))
        }

        val powerliftingButton = findViewById<Button>(R.id.toPowerLifting)
        powerliftingButton?.setOnClickListener {
            startActivity(Intent(this, ToPowerliftingActivity::class.java))
        }

        val bmiButton = findViewById<Button>(R.id.toBmiButton)
        bmiButton?.setOnClickListener {
            startActivity(Intent(this, ToBmiActivity::class.java))
        }

        val macrosButton = findViewById<Button>(R.id.toMacrosButton)
        macrosButton?.setOnClickListener {
            startActivity(Intent(this, ToMacroActivity::class.java))
        }


        val journalButton = findViewById<Button>(R.id.toJournalButton)
        journalButton?.setOnClickListener {
            startActivity(Intent(this, ToJournalActivity::class.java))
        }
        val timerButton= findViewById<Button>(R.id.toTimerButton)
        timerButton?.setOnClickListener {
            startActivity(Intent(this, ToTimerActivity::class.java))
        }


    }
}