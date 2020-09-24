package com.example.sweaty

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class ToBmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_bmi)
        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val bmiText = findViewById<EditText>(R.id.plateText)
        val weightText= findViewById<EditText>(R.id.weightText)
        val outText = findViewById<TextView>(R.id.plateOutput)
        val plateCalcButton= findViewById<Button>(R.id.plateCalcButton)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}