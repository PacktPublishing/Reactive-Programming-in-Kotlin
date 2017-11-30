package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(10,9,8,7,6,5,4,3,2,1).toObservable()
    observable.map {
        number-> "Transforming Int to String $number"
    }.subscribe {
        item-> println("Received $item")
    }
}