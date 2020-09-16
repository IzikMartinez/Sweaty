fun warmupWeights(weight: Int) {
    val warmup1 = ceiling( weight*0.5)
    val warmup2 = ceiling( weight*0.75)
    val warmup3 = ceiling( weight*0.9)

    println("First Set: $warmup1\nSecond Set: $warmup2\nThird Set: $warmup3")
}

fun ceiling(weight: Double): Double{
    var ceilWeight = weight
    while (ceilWeight % 5 !=0.0) {
        ceilWeight += 1
    }
    return ceilWeight
}