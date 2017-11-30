package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val observable = Observable.range(1,30)

    observable.groupBy {
        it%5
    }.blockingSubscribe {
        println("Key ${it.key} ")
        it.subscribe {
            println("Received $it")
        }
    }
}