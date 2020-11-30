package com.example.sweaty

import android.text.Editable
import kotlin.math.ceil

class Warmup {

    fun warmupWeights(weight: Editable): Triple<Int,Int,Int> {
        val weight = weight.toString().toDouble()
        val warmup1 = ceilingFive(ceil(weight * 0.5))
        val warmup2 = ceilingFive(ceil(weight * 0.75))
        val warmup3 = ceilingFive(ceil(weight * 0.9))

        return Triple(warmup1,warmup2,warmup3)
    }

    private fun ceilingFive(weight: Double): Int {
        var ceilWeight = weight.toInt()
        while (ceilWeight % 5 != 0) {
            ceilWeight += 1
        }
        return ceilWeight
    }
}