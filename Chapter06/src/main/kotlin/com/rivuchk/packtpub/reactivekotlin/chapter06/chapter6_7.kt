package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable1 = listOf("A", "B", "C").toObservable()
    val observable2 = listOf("D", "E", "F", "G").toObservable()
    val observable3 = listOf("I", "J", "K", "L").toObservable()
    val observable4 = listOf("M", "N", "O", "P").toObservable()
    val observable5 = listOf("Q", "R", "S", "T").toObservable()
    val observable6 = listOf("U", "V", "W", "X").toObservable()
    val observable7 = listOf("Y", "Z").toObservable()

    Observable.mergeArray(observable1, observable2, observable3,
            observable4, observable5, observable6, observable7)
            .subscribe {
                println("Received $it")
            }
}