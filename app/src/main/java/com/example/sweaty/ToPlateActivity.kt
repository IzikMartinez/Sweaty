package com.example.sweaty

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
