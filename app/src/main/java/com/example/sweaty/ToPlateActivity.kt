package com.example.sweaty

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ToPlateActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plate_cal_activity)

        val plateText = findViewById<EditText>(R.id.plateText)
        val outText = findViewById<TextView>(R.id.plateOutput)
        val plateCalcButton= findViewById<Button>(R.id.plateCalcButton)
        plateCalcButton.setOnClickListener{
            outText.text = PlateCalc(plateText.text.toString()).countPlates()
        }
    }

}


class ToWarmupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.warmup_activity)
    }
}


class ToMacroActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.macro_activity)
    }
}

class ToTemplateActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.macro_activity)

    }
}

class ToBmiActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_activity)

        val bmiText = findViewById<EditText>(R.id.plateText)
        val weightText= findViewById<EditText>(R.id.weightText)
        val outText = findViewById<TextView>(R.id.plateOutput)
        val plateCalcButton= findViewById<Button>(R.id.plateCalcButton)

    }
}


class ToBodybuildingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bodybuilding_activity)
    }
}


class ToPowerliftingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.powerlifting_activity)
    }
}


class ToJournalActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.journal_activity)
    }
}

class ToTimerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_activity)
    }
}
