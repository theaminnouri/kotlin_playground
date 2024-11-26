package org.example.problem

object MoveZeros283 {

    fun execute() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(nums)
        println(nums.toList())
    }

    fun moveZeroes(nums: IntArray): Unit {
        var indexOfZero = 0
        for (num in nums) {
            if (num != 0) {
                nums[indexOfZero] = num
                indexOfZero++
            }
        }
        for (i in indexOfZero..nums.lastIndex)
            nums[i] = 0
    }

}
