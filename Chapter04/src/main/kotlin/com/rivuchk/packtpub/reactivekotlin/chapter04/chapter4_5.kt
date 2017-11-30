package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
   Flowable.range(1,1000)//(1)
            .map { MyItem4(it) }//(2)
            .observeOn(Schedulers.computation())
            .subscribe({//(3)
                print("Received $it;\t")
                runBlocking { delay(50) }//(4)
            },{it.printStackTrace()})
    runBlocking { delay(70000) }//(5)
}


data class MyItem4 (val id:Int) {
    init {
        print("MyItem Created $id;\t")
    }
}
