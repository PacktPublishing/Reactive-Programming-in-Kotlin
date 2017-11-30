package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.schedulers.Schedulers
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking


fun main(args: Array<String>) {
    val source = Observable.range(1, 1000)
    source.toFlowable(BackpressureStrategy.BUFFER)
            .map { MyItem7(it) }
            .observeOn(Schedulers.computation())
            .subscribe{
                print("Rec. $it;\t")
                runBlocking { delay(600) }
            }
    runBlocking { delay(700000) }
}

data class MyItem7 (val id:Int) {
    init {
        print("MyItem7 init $id;\t")
    }
}