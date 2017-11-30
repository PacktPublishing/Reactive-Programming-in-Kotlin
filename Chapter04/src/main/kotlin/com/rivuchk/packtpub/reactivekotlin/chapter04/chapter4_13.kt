package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.schedulers.Schedulers
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


fun main(args: Array<String>) {
    val source = Observable.range(1, 1000)
    source.toFlowable(BackpressureStrategy.MISSING)//(1)
            .onBackpressureBuffer()//(2)
            .map { MyItem11(it) }
            .observeOn(Schedulers.io())
            .subscribe{
                println(it)
                runBlocking { delay(100) }
            }
    runBlocking { delay(600000) }
}

data class MyItem11 (val id:Int) {
    init {
        println("MyItem Created $id")
    }
}