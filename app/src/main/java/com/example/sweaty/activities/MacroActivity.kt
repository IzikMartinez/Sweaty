package com.example.sweaty.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sweaty.HarrisBenedict
import com.example.sweaty.R

class MacroActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.macro_activity)

        val carbo = findViewById<TextView>(R.id.tvCarbOut)
        val protein = findViewById<TextView>(R.id.tvProteinOut)
        val fat = findViewById<TextView>(R.id.tvFatOut)
        val calories = findViewById<TextView>(R.id.tvTotalCalories)

        val rdOne  = findViewById<RadioButton>(R.id.rdOne)
        val rdTwo = findViewById<RadioButton>(R.id.rdTwo)

        val rdbMale = findViewById<RadioButton>(R.id.rdbMale)

        val rdbLowCarb  = findViewById<RadioButton>(R.id.rdbLowCarb)
        val rdbNormal = findViewById<RadioButton>(R.id.rdbNormal)

        

        val btnGetMacros = findViewById<Button>(R.id.btnGetMacros)


        btnGetMacros.setOnClickListener() {
            val weight = findViewById<EditText>(R.id.etWeight).text.toString().toDouble()
            val height = findViewById<EditText>(R.id.etHeight).text.toString().toDouble()
            val age = findViewById<EditText>(R.id.etAge).text.toString().toDouble()

            val activity = when {
                rdOne.isChecked -> 2
                rdTwo.isChecked -> 3
                else -> 4
            }

            val gender = !rdbMale.isChecked

            val ratio = when {
                rdbLowCarb.isChecked -> 0
                rdbNormal.isChecked -> 2
                else -> 1
            }

            val hb = HarrisBenedict()
            val macros = hb.getMacros(weight, height, age, activity, ratio, gender)

            carbo.text = "Carbo: ${macros.first.toInt()}g"
            protein.text = "Protein: ${macros.second.toInt()}g"
            fat.text = "Fat: ${macros.third.toInt()}g"
            calories.text = "Daily Calories: ${macros.first.toInt() *4 + macros.second.toInt()*4 + 
                    macros.third.toInt() * 9}"
        }



    }
}