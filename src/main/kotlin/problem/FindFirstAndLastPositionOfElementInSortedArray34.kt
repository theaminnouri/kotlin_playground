package org.example.problem

object FindFirstAndLastPositionOfElementInSortedArray34 {

    fun execute() {
        println(searchRange(intArrayOf(5, 6, 6, 6, 6, 8, 10, 10), 6).toList())
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val right = findRight(nums, target)
        println("right = $right")
        val left = findLeft(nums, target)
        println("left = $left")
        return intArrayOf(left, right)
    }

    private fun findRight(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            var mid = (right + left) / 2
            if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                if (mid == nums.lastIndex || nums[mid + 1] != target) {
                    return mid
                }
                left = mid + 1
            }
        }
        return -1
    }

    private fun findLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            var mid = (right + left) / 2
            if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                if (mid == 0 || mid == nums.lastIndex || nums[mid - 1] != target) {
                    return mid
                }
                right = mid - 1
            }
        }
        return -1
    }
}
