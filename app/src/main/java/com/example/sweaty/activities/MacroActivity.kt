package com.example.sweaty.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sweaty.HarrisBenedict
import com.example.sweaty.R

class MacroFirstActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.macro_first_activity)



        val rdbMale = findViewById<RadioButton>(R.id.rdbMale)
        val gender = !rdbMale.isChecked

        val btnBioNext = findViewById<Button>(R.id.btnBioNext)

        btnBioNext.setOnClickListener() {
            val weight = findViewById<EditText>(R.id.etWeight).text.toString()
            val height = findViewById<EditText>(R.id.etHeight).text.toString()
            val age = findViewById<EditText>(R.id.etAge).text.toString()

            Intent(this, MacrosSecondActivity::class.java).also {
                if (weight == "")
                    it.putExtra("EXTRA_WEIGHT", 60.0)
                else
                    it.putExtra("EXTRA_WEIGHT", weight.toDouble())

                if (weight == "")
                    it.putExtra("EXTRA_HEIGHT", 180.0)
                else
                    it.putExtra("EXTRA_HEIGHT", height.toDouble())

                if (weight == "")
                    it.putExtra("EXTRA_AGE", 20.0)
                else
                    it.putExtra("EXTRA_AGE", age.toDouble())


                it.putExtra("EXTRA_GENDER", gender)
                startActivity(it)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}


class MacrosSecondActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.macro_second_activity)

        val weight = intent.getDoubleExtra("EXTRA_WEIGHT", 60.0)
        val height = intent.getDoubleExtra("EXTRA_HEIGHT", 180.0)
        val age = intent.getIntExtra("EXTRA_AGE", 20)
        val gender = intent.getBooleanExtra("EXTRA_GENDER", false)

        val rdOne = findViewById<RadioButton>(R.id.rdOne)
        val rdTwo = findViewById<RadioButton>(R.id.rdTwo)

        val activity = when {
            rdOne.isChecked -> 2
            rdTwo.isChecked -> 3
            else -> 4
        }

        val btnToRatio = findViewById<Button>(R.id.btnDaysWeekNext)

        btnToRatio.setOnClickListener() {
            Intent(this, MacrosThirdActivity::class.java).also {
                it.putExtra("EXTRA_ACTIVITY", activity)
                it.putExtra("EXTRA_WEIGHT", weight)
                it.putExtra("EXTRA_HEIGHT", height)
                it.putExtra("EXTRA_AGE", age)
                it.putExtra("EXTRA_GENDER", gender)
                startActivity(it)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}

class MacrosThirdActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.macro_third_activity)

        val weight = intent.getDoubleExtra("EXTRA_WEIGHT", 60.0)
        val height = intent.getDoubleExtra("EXTRA_HEIGHT", 180.0)
        val age = intent.getDoubleExtra("EXTRA_AGE", 20.0)
        val activity = intent.getIntExtra("EXTRA_ACTIVITY", 1)

        val gender = intent.getBooleanExtra("EXTRA_GENDER", false)
        val btnGetMacros = findViewById<Button>(R.id.btnGetMacros)

        val carbs = findViewById<TextView>(R.id.tvCarbOut)
        val protein = findViewById<TextView>(R.id.tvProteinOut)
        val fat = findViewById<TextView>(R.id.tvFatOut)
        val calories = findViewById<TextView>(R.id.tvCalOut)

        val rdbLowCarb = findViewById<RadioButton>(R.id.rdbLowCarb)
        val rdbNormal = findViewById<RadioButton>(R.id.rdbNormal)

        btnGetMacros.setOnClickListener() {

            val ratio = when {
                rdbLowCarb.isChecked -> 0
                rdbNormal.isChecked -> 2
                else -> 1
            }

            val hb = HarrisBenedict()
            val macros = hb.getMacros(weight, height, age, activity, ratio, gender)

            carbs.text = "Carbo: ${macros.first.toInt()}g"
            protein.text = "Protein: ${macros.second.toInt()}g"
            fat.text = "Fat: ${macros.third.toInt()}g"
            calories.text = "Daily Calories: ${macros.first.toInt() *4 + macros.second.toInt()*4 + 
                    macros.third.toInt() * 9}"
        }
    }
}