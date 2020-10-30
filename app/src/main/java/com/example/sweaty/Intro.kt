package com.example.sweaty

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)
        val logo =findViewById<ImageView>(R.id.imageLoading)
        val welcomeText =findViewById<TextView>(R.id.textView7)
        val objectAnimator = ObjectAnimator.ofFloat(logo, "rotation", 0f, 360f)
        objectAnimator.duration = 2800

        objectAnimator.repeatCount = ObjectAnimator.INFINITE;
        objectAnimator.repeatMode = ObjectAnimator.RESTART;

        objectAnimator.start()
        welcomeText.text ="Welcome to Sweaty !"
        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 7000)

    }
}