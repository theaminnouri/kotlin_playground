package org.example

object BoatsToSavePeople_881 {


    fun execute() {
        val numRescueBoats1 = numRescueBoats(people = intArrayOf(1, 2), limit = 3)
        println("$numRescueBoats1 ${numRescueBoats1 == 1}  expected = 1")

        val numRescueBoats2 = numRescueBoats(people = intArrayOf(3, 3, 4, 5), limit = 5)
        println("$numRescueBoats2 ${numRescueBoats2 == 4}  expected = 4")

        val numRescueBoats3 = numRescueBoats(
            people = intArrayOf(2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10), limit = 50
        )
        println("$numRescueBoats3 ${numRescueBoats3 == 11} expected = 11")

        val numRescueBoats4 = numRescueBoats(people = intArrayOf(3, 2, 2, 1), limit = 3)
        println("$numRescueBoats4 ${numRescueBoats4 == 3}  expected = 3")
    }


    fun numRescueBoats(people: IntArray, limit: Int, boatsPeoplesLimit: Int = 2): Int {
        val sortedPeople = people.sorted()
        if (sortedPeople.last() > limit) {
            return 0
        }
        var numberOfBoats = 0
        var l = 0
        var r = sortedPeople.lastIndex
        while (l <= r) {
            var sum = sortedPeople[r]
            var remainedSit = boatsPeoplesLimit - 1
            while (remainedSit > 0 && sum + sortedPeople[l] <= limit) {
                remainedSit--
                sum += sortedPeople[l]
                l++
            }
            r--
            numberOfBoats++
        }
        return numberOfBoats
    }

}