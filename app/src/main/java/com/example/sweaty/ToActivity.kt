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
        val outText = findViewById<TextView>(R.id.outWeightText)
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

        val weightText = findViewById<EditText>(R.id.warmupInputText);
        val weightBtn = findViewById<Button>(R.id.warmupButton);
        val outText = findViewById<EditText>(R.id.warmupOutput);

        weightBtn.setOnClickListener {
            outText.setText(Warmup().warmupWeights(weightText.text))
        }
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

        val outText = findViewById<EditText>(R.id.bmiOutText)
        val heightText = findViewById<EditText>(R.id.bmiHeightText).text
        val weightText = findViewById<EditText>(R.id.bmiWeightText).text
        val bmiCalcButton = findViewById<Button>(R.id.bmiCalcButton)
        bmiCalcButton.setOnClickListener{
            outText.setText( BmiCalc(heightText.toString(), weightText.toString()).calculateBMI() )
        }


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
