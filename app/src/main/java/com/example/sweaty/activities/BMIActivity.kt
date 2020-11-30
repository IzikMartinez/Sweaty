package com.example.sweaty.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sweaty.BmiCalc
import com.example.sweaty.MainActivity
import com.example.sweaty.R
import com.example.sweaty.UserData

class BMIActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_activity)

        val btnNext = findViewById<Button>(R.id.btnBmiNxt)

        btnNext.setOnClickListener() {
            if (UserData.weight != 0)
                findViewById<EditText>(R.id.bmiWeightText).setText(UserData.weight)

            val weight = findViewById<EditText>(R.id.bmiWeightText).text.toString()

            Intent(this, BMISecondActivity::class.java).also {
                if (weight == "")
                    it.putExtra("EXTRA_WEIGHT", 60.0)
                else
                    it.putExtra("EXTRA_WEIGHT", weight.toDouble())
                UserData.weight = weight.toInt()

                startActivity(it)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}


class BMISecondActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_activity2)

        if (UserData.height != 0)
            findViewById<EditText>(R.id.bmiHeightText).setText(UserData.height)

        val weight = intent.getDoubleExtra("EXTRA_WEIGHT",60.0)

        val btnCalculate = findViewById<Button>(R.id.bmiCalcButton)

        btnCalculate.setOnClickListener() {
            val height = findViewById<EditText>(R.id.bmiHeightText).text.toString()

            Intent(this, BMIThirdActivity::class.java).also {

                if (height == "")
                    it.putExtra("EXTRA_HEIGHT", 180.0)
                else
                    it.putExtra("EXTRA_HEIGHT", height.toDouble())

                UserData.height = height.toInt()

                startActivity(it)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}



class BMIThirdActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_activity3)

        val outText = findViewById<TextView>(R.id.bmiOutText)
        val heightText =intent.getDoubleExtra("EXTRA_HEIGHT", 180.0)
        val weightText = intent.getDoubleExtra("EXTRA_WEIGHT", 60.0)

        outText.setText(BmiCalc(heightText, weightText).calculateBMI())
        outText.setText(BmiCalc(heightText, weightText).calculateBMI())

        val home = findViewById<Button>(R.id.btnHome)

        home.setOnClickListener{
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }
}