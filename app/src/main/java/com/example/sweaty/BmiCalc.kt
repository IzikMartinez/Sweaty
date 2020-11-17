package com.example.sweaty

class BmiCalc constructor(height: Double, weight: Double) {
    private val weight = weight
    private val height = height

    fun calculateBMI(): String {
        val out = ((weight /  (height * height))* 703)
        return "$out"
    }
}