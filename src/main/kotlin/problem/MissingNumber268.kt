package org.example.problem

object MissingNumber268 {
    fun execute() {

    }

    fun optimalMissingNumber(nums: IntArray): Int {
        val sum = nums.sum()
        val n = nums.size
        val expectedSum = (n * (n + 1)) / 2
        return expectedSum - sum
    }

    fun missingNumber(nums: IntArray): Int {
        val sortedNums = nums.sorted()
        var missing = -1
        for (i in 0..sortedNums.size) {
            if (i > sortedNums.lastIndex || i != sortedNums[i]) {
                missing = i
                break
            }
        }
        return missing
    }
}
