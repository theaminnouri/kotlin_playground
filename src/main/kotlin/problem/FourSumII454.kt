package org.example.problem

object FourSumII454 {

    fun execute() {
        val answer = fourSumCount(
            nums1 = intArrayOf(1, 2),
            nums2 = intArrayOf(-2, -1),
            nums3 = intArrayOf(-1, 2),
            nums4 = intArrayOf(0, 2),
        )
        println("$answer == 2")
        val optimizedAnswer = optimizedFourSumCount(
            nums1 = intArrayOf(1, 2),
            nums2 = intArrayOf(-2, -1),
            nums3 = intArrayOf(-1, 2),
            nums4 = intArrayOf(0, 2),
        )
        println("$optimizedAnswer == 2")
    }

    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        var answer = 0
        for (i in nums1.indices) {
            for (j in nums2.indices) {
                for (k in nums3.indices) {
                    for (l in nums4.indices) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            answer++
                        }
                    }
                }
            }
        }
        return answer
    }

    fun optimizedFourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        var answer = 0
        val map = mutableMapOf<Int, Int>()
        for (i in nums1.indices) {
            for (j in nums2.indices) {
                val key = nums1[i] + nums2[j]
                map[key] = (map[key] ?: 0) + 1
            }
        }
        for (k in nums3.indices) {
            for (l in nums4.indices) {
                val key = nums3[k] + nums4[l]
                if (map.containsKey(-key)) {
                    answer += (map[-key] ?: 0)
                }
            }
        }

        return answer
    }
}