package com.rivuchk.packtpub.reactivekotlin.chapter8

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    Observable.range(1,10)
            .subscribeOn(Schedulers.computation())
            .subscribe {
                item -> println("Received $item")
            }
    runBlocking { delay(10) }
}