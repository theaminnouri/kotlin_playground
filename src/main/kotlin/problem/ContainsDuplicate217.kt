package org.example.problem

object ContainsDuplicate217 {
    fun execute() {
        val hasDuplicate = containsDuplicate(intArrayOf(1, 2, 3, 1))
        println("should have Duplicate $hasDuplicate")
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Boolean>()
        for (i in nums) {
            if (map[i] == true) {
                return true
            } else {
                map[i] = true
            }
        }
        return false
    }

}
