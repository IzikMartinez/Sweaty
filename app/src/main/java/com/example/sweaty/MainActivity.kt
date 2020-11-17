package com.example.sweaty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sweaty.activities.BMIActivity
import com.example.sweaty.activities.MacroFirstActivity
import com.example.sweaty.activities.MacrosSecondActivity
import com.example.sweaty.activities.WendlerActivity
import com.example.sweaty.UserData

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        UserData.init(this)
        val plateButton = findViewById<Button>(R.id.toPlateButton)
        plateButton?.setOnClickListener {
            startActivity(Intent(this, ToPlateActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }

        val warmupButton = findViewById<Button>(R.id.warmupButton)
        warmupButton?.setOnClickListener {
            startActivity(Intent(this, ToWarmupActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }

        val bmiButton = findViewById<Button>(R.id.toBmiButton)
        bmiButton?.setOnClickListener {
            startActivity(Intent(this, BMIActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }

        val macrosButton = findViewById<Button>(R.id.toMacrosButton)
        macrosButton?.setOnClickListener {
            Intent(this, MacroFirstActivity::class.java).also {
                startActivity(it)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            }
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }

        val journalButton = findViewById<Button>(R.id.toJournalButton)
        journalButton?.setOnClickListener {
            startActivity(Intent(this, WendlerActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        }

        val timerButton= findViewById<Button>(R.id.toTimerButton)
        timerButton?.setOnClickListener {
            startActivity(Intent(this, ToTimerActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)

        }


    }
}