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

        val gender = intent.getBooleanExtra("EXTRA_GENDER", false)


        val carbo = findViewById<TextView>(R.id.tvCarbOut)
        val protein = findViewById<TextView>(R.id.tvProteinOut)
        val fat = findViewById<TextView>(R.id.tvFatOut)
        val calories = findViewById<TextView>(R.id.tvTotalCalories)

        

        val btnGetMacros = findViewById<Button>(R.id.btnGetMacros)


        btnGetMacros.setOnClickListener() {
            val weight = findViewById<EditText>(R.id.etWeight).text.toString().toDouble()
            val height = findViewById<EditText>(R.id.etHeight).text.toString().toDouble()
            val age = findViewById<EditText>(R.id.etAge).text.toString().toDouble()

            val hb = HarrisBenedict()
            val macros = hb.getMacros(weight,height, age,4, 2)

            carbo.text = "Carbo: ${macros.first.toInt()}"
            protein.text = "Protein: ${macros.second.toInt()}"
            fat.text = "Fat: ${macros.third.toInt()}"
            calories.text = "Daily Calories: ${macros.first.toInt() + macros.second.toInt() + macros.third.toInt()}"
        }



    }
}