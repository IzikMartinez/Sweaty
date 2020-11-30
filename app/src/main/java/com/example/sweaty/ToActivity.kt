package com.example.sweaty
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


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
        val firstSet = findViewById<TextView>(R.id.tvFirstSet);
        val secondSet = findViewById<TextView>(R.id.tvSecondSet);
        val thirdSet = findViewById<TextView>(R.id.tvThirdSet);

        weightBtn.setOnClickListener {
            val warmSets = Warmup().warmupWeights(weightText.text)
            firstSet.setText("${warmSets.first.toString()} x 5")
            secondSet.setText("${warmSets.second.toString()} x 3")
            thirdSet.setText("${warmSets.third.toString()} x 1")
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
    }
}

class ToJournalActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_activity)
    }
}

class ToTimerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_activity)

        val inputTime = findViewById<EditText>(R.id.txtTimeInput)
        val start = findViewById<Button>(R.id.btnStart)
        val reset = findViewById<Button>(R.id.btnReset)
        val timer = findViewById<TextView>(R.id.txtTimer)
        val progressTimer = findViewById<ProgressBar>(R.id.progressBarTimer)

        start.setOnClickListener{
            val input = inputTime.text.toString()
            if(input.isNotEmpty() && Integer.valueOf(input) > 0){
            progressTimer.max = Integer.valueOf(input)*60000
            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            inputManager.hideSoftInputFromWindow(
                currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
            inputTime.setEnabled(false)
            Timer(input).startTimeCounter(this,inputTime, timer, progressTimer, reset)

            }else{
                Toast.makeText(applicationContext,"Enter Minutes Greater Than 0",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
