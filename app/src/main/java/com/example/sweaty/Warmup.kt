package com.example.sweaty

import android.text.Editable
import kotlin.math.ceil

class Warmup {

    fun warmupWeights(weight: Editable): String {
        val weight = weight.toString().toDouble()
        val warmup1 = ceilingFive(ceil(weight * 0.5))
        val warmup2 = ceilingFive(ceil(weight * 0.75))
        val warmup3 = ceilingFive(ceil(weight * 0.9))

        return "First Warm-up Set: $warmup1 x 5\nSecond Warm-up Set: $warmup2 x3\nThird Warm-up Set: $warmup3 x1"
    }

    fun ceilingFive(weight: Double): Double {
        var ceilWeight = weight
        while (ceilWeight % 5 != 0.0) {
            ceilWeight += 1
        }
        return ceilWeight
    }
}