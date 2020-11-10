package com.example.sweaty

/*
This class implements the Revised Harris-Benedict equation to calculate macro-nutrient needs.

Note: This class utilizes functional programming. That is; every function performs one and
only one task. Complex functionality is achieved by chaining functions together.
Functional programming is both easier to compose than traditional object oriented programming,
and results in fewer errors to the lack of 'side effects'.
*/

class HarrisBenedict {
    private var gender: Boolean = false;
    private var wCo = 0.0  // weight coefficient
    private var hCo = 0.0 // height coefficient
    private var aCo = 0.0 // age coefficient
    private var const = 0.0


    private fun setCoefficients(gender: Boolean) {
        // Female
        if (gender)  {
            wCo = 9.247
            hCo = 3.098
            aCo = 4.330
            const = 447.593
        } else {
            wCo = 13.397
            hCo = 4.799
            aCo = 5.677
            const = 88.362
        }
    }

    private fun setActivityLevel(activity: Int): Double {
        return when (activity) {
            0 -> 1.2 // sedentary
            1 -> 1.375  //  light exercise
            2 -> 1.55 // moderately active
            3 -> 1.725 // Very active lifestyle
            else -> 1.9 // Extremely active
        }
    }

    private fun baseMetabolicRate(weight: Double, height: Double, age: Double, gender: Boolean): Double {
        setCoefficients(gender)
        return wCo*weight + hCo*height - aCo*age + const
    }

    private fun totalEnergyExpenditure(weight: Double, height: Double, age: Double,
                                       activity: Int, gender: Boolean)
            : Double { // Return type
        return baseMetabolicRate(weight, height, age, gender) * setActivityLevel(activity)
    }

    fun getMacros(weight: Double, height: Double, age: Double,
                  activity: Int, ratio: Int, gender: Boolean)
            : Triple<Double,Double,Double>
    {
        val tee = totalEnergyExpenditure(weight, height, age, activity, gender)

        val carbs = when (ratio) {
            0 -> 0.2* tee
            1 -> 0.55* tee
            2 -> 0.4 * tee
            else -> 0.33 * tee
        } / 4

        val protein = when (ratio) {
            0 -> 0.35* tee
            1 -> 0.35* tee
            2 -> 0.35 * tee
            else -> 0.33 * tee
        } / 4
        
        val fat = when (ratio) {
            0 -> 0.45 * tee
            1 -> 0.1 * tee
            2 -> 0.25 * tee
            else -> 0.33 * tee
        } / 9

        return Triple(carbs,protein,fat)
    }



}