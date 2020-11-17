package com.example.sweaty

class Wendler constructor() {

    private fun ceilingFive(weight: Double): Double {
        var ceilWeight = weight.toInt()
        while (ceilWeight % 5 != 0) {
            ceilWeight += 1
        }
        return ceilWeight.toDouble()
    }

    private fun assignOneRepMax(gender: Boolean): Double {
        return if (!gender)
            0.85
        else
            0.95
    }

    private fun wendlerFormula (weight: Int, reps: Int): Double {
        return weight * reps * 0.0333
    }

    private fun oneRepMax(weight: Int, reps: Int): Double {
        return weight + wendlerFormula(weight,reps)
    }

    private fun workingWeight(weight: Int, reps: Int, gender: Boolean): Double {
        return oneRepMax(weight, reps) * assignOneRepMax(gender)
    }

    private fun ceilingWendler(weight: Int, reps: Int, gender: Boolean): Double {
       val newWeight = ceilingFive(workingWeight(weight,reps,gender))
        return if (newWeight <= weight.toDouble())
            weight + 5.0
        else
            newWeight
    }

    fun splitA(     sWeight: Int, sReps: Int,
                    pWeight: Int, pReps: Int,
                    pcWeight: Int, pcReps: Int, gender: Boolean)
            : Triple<Double,Double,Double> {

        val squat = ceilingWendler(sWeight, sReps, gender)
        val press = ceilingWendler(pWeight,pReps, gender)
        val powerClean = ceilingWendler(pcWeight, pcReps, gender)

        return Triple(squat,press,powerClean)
    }


    fun splitB(     bWeight: Int, bReps: Int,
                    dWeight:Int, dReps: Int,
                    psWeight: Int, psReps: Int, gender: Boolean)
            : Triple<Double,Double,Double>{

        val benchPress = ceilingWendler(bWeight, bReps, gender)
        val deadlift = ceilingWendler(dWeight,dReps, gender)
        val powerSnatch = ceilingWendler(psWeight,psReps, gender)

        return Triple( benchPress, deadlift, powerSnatch )
    }
}