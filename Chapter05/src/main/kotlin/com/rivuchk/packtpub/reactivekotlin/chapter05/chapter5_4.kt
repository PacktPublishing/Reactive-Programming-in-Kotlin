package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(10,1,2,5,8,6,9)
            .toObservable()

    observable.elementAt(5)//(1)
            .subscribe { println("Received $it") }

    observable.elementAt(50)//(2)
            .subscribe { println("Received $it") }
}