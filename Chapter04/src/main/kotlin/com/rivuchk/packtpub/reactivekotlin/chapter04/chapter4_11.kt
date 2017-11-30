package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.schedulers.Schedulers
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


fun main(args: Array<String>) {
    val source = Observable.range(1, 1000)
    source.toFlowable(BackpressureStrategy.DROP)
            .map { MyItem8(it) }
            .observeOn(Schedulers.computation())
            .subscribe{
                print("Rec $it;\t")
                runBlocking { delay(100) }
            }
    runBlocking { delay(70000) }
}

data class MyItem8 (val id:Int) {
    init {
        print("init $id;\t")
    }
}