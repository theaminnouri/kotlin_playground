package org.example.problem

object ValidMountainArray_941 {

    fun execute() {
        val intArray = intArrayOf(0, 3, 2, 1)
        println(validMountainArray(intArray))
    }

    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) {
            return false
        }
        val length = arr.size - 1
        var pivot = 0
        for (i in 0..<length) {
            if (i == pivot && arr[i] < arr[i + 1] && i + 1 < length) {
                pivot++
            } else if (pivot > 0 && arr[i] > arr[i + 1]) {
                continue
            } else {
                return false
            }
        }
        return true
    }


}