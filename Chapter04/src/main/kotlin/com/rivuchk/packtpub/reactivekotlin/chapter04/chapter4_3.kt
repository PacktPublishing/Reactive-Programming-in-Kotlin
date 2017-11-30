package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6,7,8,9)//(1)
    observable
            .map { MyItem2(it) }//(2)
            .subscribe({//(3)
                println("Received $it")
                runBlocking { delay(200) }//(4)
            })
    runBlocking { delay(2000) }//(5)
}

data class MyItem2 (val id:Int) {


    init {
        println("MyItem Created $id")
    }
}
