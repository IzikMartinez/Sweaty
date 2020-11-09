package com.example.sweaty

class Wendler constructor(gender: Boolean) {

    private val ceiling = Warmup()
    private var ormPercent = 0.0

    private fun assignOneRepMax(gender: Boolean) {
        ormPercent = if (gender)
            0.95
        else
            0.85
    }

    private fun wendlerFormula (weight: Int, reps: Int): Double {
        return weight * reps * 0.0333
    }

    private fun ceilingWendler(weight: Int, reps: Int): Double {
        return ceiling.ceilingFive( (weight + wendlerFormula(weight,reps)) * ormPercent)
    }

    fun splitA(     sWeight: Int, sReps: Int,
                    pWeight: Int, pReps: Int,
                    pcWeight: Int, pcReps: Int)
            : Triple<Double,Double,Double> {

        val squat = ceilingWendler(sWeight, sReps)
        val press = ceilingWendler(pWeight,pReps)
        val powerClean = ceilingWendler(pcWeight, pcReps)

        return Triple(squat,press,powerClean)
    }


    fun splitB(     bWeight: Int, bReps: Int,
                    dWeight:Int, dReps: Int,
                    psWeight: Int, psReps: Int)
            : Triple<Double,Double,Double>{

        val benchPress = ceilingWendler(bWeight, bReps)
        val deadlift = ceilingWendler(dWeight,dReps)
        val powerSnatch = ceilingWendler(psWeight,psReps)

        return Triple( benchPress, deadlift, powerSnatch )
    }
}