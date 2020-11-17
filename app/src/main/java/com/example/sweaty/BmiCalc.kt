package com.example.sweaty

class BmiCalc constructor(height: Double, weight: Double) {
    private val weight = weight
    private val height = height/100

    fun calculateBMI(): String {
        val out = weight / (height * height)
        return "$out"
    }
}