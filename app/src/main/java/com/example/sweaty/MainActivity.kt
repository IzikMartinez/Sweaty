package com.example.sweaty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sweaty.activities.MacroActivity
import com.example.sweaty.activities.WendlerActivity

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

        val bmiButton = findViewById<Button>(R.id.toBmiButton)
        bmiButton?.setOnClickListener {
            startActivity(Intent(this, ToBmiActivity::class.java))
        }

        val macrosButton = findViewById<Button>(R.id.toMacrosButton)
        macrosButton?.setOnClickListener {
            val gender = false
            Intent(this, MacroActivity::class.java).also {
                it.putExtra("EXTRA_GENDER", gender)
                startActivity(it)
            }
        }


        val journalButton = findViewById<Button>(R.id.toJournalButton)
        journalButton?.setOnClickListener {
            startActivity(Intent(this, WendlerActivity::class.java))
        }
        val timerButton= findViewById<Button>(R.id.toTimerButton)
        timerButton?.setOnClickListener {
            startActivity(Intent(this, ToTimerActivity::class.java))
        }


    }
}