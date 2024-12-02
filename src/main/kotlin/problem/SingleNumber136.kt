package org.example.problem

object SingleNumber136 {

    fun execute() {
        val singleNumber = singleNumber(nums = intArrayOf(4, 1, 2, 1, 2))
        println("$singleNumber should be 4")
        val singleNumber1 = singleNumber(nums = intArrayOf(2, 2, 1))
        println("$singleNumber1 should be 1")

        val singleNumber2 = optimalSingleNumber(nums = intArrayOf(4, 1, 2, 1, 2))
        println("$singleNumber2 should be 4")
        val singleNumber3 = optimalSingleNumber(nums = intArrayOf(2, 2, 1))
        println("$singleNumber3 should be 1")

        val singleNumber4 = secondOptimalSingleNumber(nums = intArrayOf(4, 1, 2, 1, 2))
        println("$singleNumber4 should be 4")
        val singleNumber5 = secondOptimalSingleNumber(nums = intArrayOf(2, 2, 1))
        println("$singleNumber5 should be 1")

    }

    fun secondOptimalSingleNumber(nums: IntArray): Int {
        var result = 0
        for (i in nums) {
            result = result xor i
        }
        return result
    }

    fun optimalSingleNumber(nums: IntArray): Int {
        val expectedSum = nums.toSet().sum() * 2
        val singleNumber = expectedSum - nums.sum()
        return singleNumber
    }

    fun singleNumber(nums: IntArray): Int {
        val sortedNumbs = nums.sorted()
        var previousNum = sortedNumbs.first()
        var numCount = 1
        for (i in 1..sortedNumbs.lastIndex) {
            if (previousNum == sortedNumbs[i]) {
                numCount++
            } else {
                if (numCount < 2) {
                    return previousNum
                } else {
                    numCount = 1
                    previousNum = sortedNumbs[i]
                }
            }
        }
        return previousNum
    }
}
