package org.example.problem

object TwoSum1 {

    fun execute() {
        val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
        println("${result.toList()} should be [0,1]")
    }

    // implement optimal one
    fun optimalTwoSum(nums: IntArray, target: Int): IntArray {
        return intArrayOf()
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0..nums.lastIndex) {
            for (j in i..nums.lastIndex) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}
