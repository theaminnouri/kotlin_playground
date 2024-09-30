package com.theaminnouri

fun printList(l: List<Any>) {
//    when (l) {
//        is List<String> -> println("Strings: $l")
//        is List<Int> -> println("Integers: $l")
//    }
}

fun readNumbersOrWords(): List<Any> {
    val input = readln()
    val words: List<String> = input.split(",")
    val numbers: List<Int> = words.mapNotNull { it.toIntOrNull() }
    return numbers.ifEmpty { words }
}

//fun main() {
//    val list = readNumbersOrWords()
//    printList(list)

//}
//------------------------------------------------

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

//fun main() {

//    printSum(listOf(1, 2, 3))
    // 6

//    printSum(setOf(1, 2, 3))
    // IllegalArgumentException: List is expected


//    printSum(listOf("a", "b", "c"))
    // ClassCastException: String cannot be cast to Number
//}

//fun <T> isA(value: Any) = value is T
// Error: Cannot check for instance of erased type: T


inline fun <reified T> isA(value: Any) = value is T

fun main() {
    println(
        isA<String>("abc")
    )
    // true
    println(isA<String>(123))
    // false
}