package com.example.sweaty

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit

class Timer constructor(input: String) {
    private val input =  input.toInt();
    private val milliseconds = (this.input * 60000);
    private var minutes = 0
    private var seconds = 0
    private var textTimer = ""

    fun startTimeCounter(view: ToTimerActivity, inputTime: EditText, textView: TextView, countProgress: ProgressBar,reset: Button) {
        object : CountDownTimer(milliseconds.toLong(), 1000) {
            var color = textView.textColors
            override fun onTick(millisUntilFinished: Long) {
                textTimer = java.lang.String.format(
                Locale.getDefault(), "Time Remaining - %02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                )
                textView.setText(textTimer)
                countProgress.setProgress(millisUntilFinished.toInt())
                if(millisUntilFinished < 10000)
                textView.setTextColor(Color.RED)
                reset.setOnClickListener{
                    textView.text = "Time Remaining - 00:00"
                    countProgress.setProgress(0)
                    inputTime.setEnabled(true)
                    cancel()
                }

            }

            override fun onFinish() {
                textView.text = "Time Finished"
                textView.setTextColor(color)
                countProgress.setProgress(0)
                inputTime.setEnabled(true)
                cancel()


            }
        }.start()
    }

}