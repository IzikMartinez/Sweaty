package com.example.sweaty

class BmiCalc constructor(height: String, weight: String) {
    private val weight = weight.toFloat()
    private val height = height.toFloat()

    fun calculateBMI(): String {
        val out = ((weight /  (height * height))* 703)
        return "$out"
    }
}