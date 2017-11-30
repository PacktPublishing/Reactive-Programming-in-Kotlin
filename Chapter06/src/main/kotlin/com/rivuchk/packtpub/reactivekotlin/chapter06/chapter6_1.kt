package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable

fun main(args: Array<String>) {
    println("startWith Iterator")
    Observable.range(5,10)
            .startWith(listOf(1,2,3,4))//(1)
            .subscribe {
                println("Received $it")
            }
    println("startWith another source Producer")
    Observable.range(5,10)
            .startWith(Observable.just(1,2,3,4))//(2)
            .subscribe {
                println("Received $it")
            }
}