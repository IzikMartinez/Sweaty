package com.example.sweaty.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sweaty.Wendler
import com.example.sweaty.R
import com.example.sweaty.UserData


class WendlerActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_activity)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val rdOne = findViewById<RadioButton>(R.id.rdOne)
        val rdTwo = findViewById<RadioButton>(R.id.rdTwo)

        val rdbGender = findViewById<RadioGroup>(R.id.rgpGender)
        val rdbMale = findViewById<RadioButton>(R.id.rdbMale)

/*        if (UserData.gender)
            rdbGender.check(R.id.rdbMale)
        else
            rdbGender.check(R.id.rdFemale)*/

        btnCalculate.setOnClickListener() {
            val lift1 = findViewById<EditText>(R.id.editLift1).text.toString().toInt()
            val lift2 = findViewById<EditText>(R.id.editLift2).text.toString().toInt()
            val lift3 = findViewById<EditText>(R.id.editLift3).text.toString().toInt()

            val reps1 = findViewById<EditText>(R.id.editReps1).text.toString().toInt()
            val reps2 = findViewById<EditText>(R.id.editReps2).text.toString().toInt()
            val reps3 = findViewById<EditText>(R.id.editReps3).text.toString().toInt()

            val displayWeight1 = findViewById<TextView>(R.id.tvLift1)
            val displayWeight2 = findViewById<TextView>(R.id.tvLift2)
            val displayWeight3 = findViewById<TextView>(R.id.tvLift3)

            val gender = rdbMale.isChecked

            UserData.gender = gender

            val wen = Wendler()
            if (rdOne.isChecked) {
                val weight = wen.splitA(lift1, reps1, lift2, reps2, lift3, reps3, gender)
                displayWeight1.text = "Squat: ${weight.first.toInt()} lbs"
                displayWeight2.text = "Press: ${weight.second.toInt()} lbs"
                displayWeight3.text = "Clean: ${weight.third.toInt()} lbs"
            }
            else if(rdTwo.isChecked)
            {
                val weight = wen.splitB(lift1, reps1, lift2, reps2, lift3, reps3, gender)
                displayWeight1.text = "Bench: ${weight.first.toInt()} lbs"
                displayWeight2.text = "Deadlift: ${weight.second.toInt()} lbs"
                displayWeight3.text = "Snatch: ${weight.third.toInt()} lbs"
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked
            val txtSplit = findViewById<TextView>(R.id.txtSplit)
            val edLift1 = findViewById<EditText>(R.id.editLift1)
            val edLift2 = findViewById<EditText>(R.id.editLift2)
            val edLift3 = findViewById<EditText>(R.id.editLift3)

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rdOne ->
                    if (checked) {
                        txtSplit.text = "Split A"
                        edLift1.setHint("Squat weight (lb)")
                        edLift2.setHint("Press weight (lb)")
                        edLift3.setHint("Clean weight (lb)")
                    }
                R.id.rdTwo ->
                    if (checked) {
                        txtSplit.text = "Split B"
                        edLift1.setHint("Bench weight (lb)")
                        edLift2.setHint("Deadlift weight (lb)")
                        edLift3.setHint("Snatch weight (lb)")
                    }
            }
        }
    }
}

