package org.example.problem

object AddBinary67 {

    fun execute() {
        val result = addBinary(a = "1010", b = "1011")
        println("$result should be 10101")
    }

    fun addBinary(a: String, b: String): String {
        var newA = a
        var newB = b
        val lengthOfA = a.length
        val lengthOfB = b.length
        if (lengthOfB > lengthOfA) {
            for (i in 0 until lengthOfB - lengthOfA)
                newA = "0$newA"
        } else if (lengthOfA > lengthOfB) {
            for (i in 0 until lengthOfA - lengthOfB)
                newB = "0$newB"
        }
        var carry = 0
        var result = ""
        for (i in newA.lastIndex downTo 0) {
            var sum = carry
            sum += newB[i].digitToInt() + newA[i].digitToInt()
            carry = sum / 2
            result = "${sum % 2}$result"
        }
        if (carry > 0) {
            result = "$carry$result"
        }
        return result
    }

}
