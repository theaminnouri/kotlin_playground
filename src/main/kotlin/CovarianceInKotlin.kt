package com.theaminnouri

class CovarianceInKotlin {
}

open class Animal {
    fun feed() {}
}

class Cat : Animal() {

    fun clearLitter() {

    }
}


class Herd<T : Animal> {
    private val list: List<T> = emptyList()
    val size: Int get() = list.size

    operator fun get(i: Int): T {
        return list[i]
    }
}

fun feedALL(animals: Herd<Animal>) {
    for (i in 0..<animals.size) {
        animals[i].feed()
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0..<cats.size) {
        cats[i].clearLitter()
    }

//    feedALL(cats)
}