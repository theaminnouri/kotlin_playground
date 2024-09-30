package com.theaminnouri

import JBox


class KBox<T : Any>: JBox<T> {
    override fun put(t: T) { /* ... */ }
    override fun putIfNotNull(t: T) { /* Problem! */ }
}

class KBox2<T>: JBox<T> {
    override fun put(t: T & Any) { /* ... */ }
    override fun putIfNotNull(t: T) { /* ... */ }
}