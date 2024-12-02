package org.example.problem

import kotlin.math.ceil
import kotlin.math.sqrt

object CountPrimes204 {

    fun execute() {
        println(countPrimes(10))
    }

    private fun countPrimes(n: Int): Int {
        if (n < 3) {
            return 0
        }
        val isPrimeMap = BooleanArray(n) { true }
        isPrimeMap[0] = false
        isPrimeMap[1] = false

        val sqrtN = ceil(sqrt(n.toDouble())).toInt()
        for (i in 2..sqrtN) {
            if (isPrimeMap[i]) {
                var j = i + i
                while (j < n) {
                    isPrimeMap[j] = false
                    j += i
                }
            }
        }

        var primeCount = 0
        for (k in 0 until n) {
            if (isPrimeMap[k]) {
                primeCount++
            }
        }

        val size = isPrimeMap.filter { predicate ->
            predicate
        }.size
        return size
    }
}